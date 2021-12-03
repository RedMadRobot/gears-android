@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * Wrapper to make it possible to work with plain [String] and [StringRes] in the same way.
 *
 * ```
 *  // in some place where we can't access Context
 *  val errorMessage = exception.message?.let(Text::Plain) ?: Text.Resource(R.string.unknown_error)
 *  showMessage(errorMessage)
 *
 *  // in Activity, Fragment or View
 *  val messageText = getString(message)
 * ```
 */
public sealed class Text : Parcelable {

    /** Retrieves [String] using given [context]. */
    public abstract fun get(context: Context): String

    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int

    /** Plain string. */
    public data class Plain(public val string: String) : Text() {

        private constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

        override fun get(context: Context): String = string

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(string)
        }

        override fun describeContents(): Int = 0

        public companion object CREATOR : Parcelable.Creator<Plain> {

            override fun createFromParcel(parcel: Parcel): Plain = Plain(parcel)

            override fun newArray(size: Int): Array<Plain?> = arrayOfNulls(size)
        }
    }

    /** String resource, requires [Context] to get [String]. */
    public data class Resource(@StringRes public val resourceId: Int) : Text() {

        private constructor(parcel: Parcel) : this(parcel.readInt())

        override fun get(context: Context): String = context.getString(resourceId)

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(resourceId)
        }

        override fun describeContents(): Int = 0

        public companion object CREATOR : Parcelable.Creator<Resource> {

            override fun createFromParcel(parcel: Parcel): Resource = Resource(parcel)

            override fun newArray(size: Int): Array<Resource?> = arrayOfNulls(size)
        }
    }
}

/**
 * Unwraps and returns a string for the given [text].
 * @see Text
 */
public inline fun Context.getString(text: Text): String = text.get(this)

/**
 * Unwraps and returns a string for the given [text].
 * @see Text
 */
public inline fun Fragment.getString(text: Text): String = requireContext().getString(text)

/**
 * Unwraps and returns a string for the given [text].
 * @see Text
 */
public inline fun View.getString(text: Text): String = context.getString(text)
