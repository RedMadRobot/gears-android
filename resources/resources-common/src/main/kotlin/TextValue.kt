@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.content.Context
import android.os.Parcelable
import android.view.View
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

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
public sealed class TextValue : Parcelable {

    /** Retrieves [String] using given [context]. */
    public abstract fun get(context: Context): String

    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int

    /** Plain string. */
    @Parcelize
    public data class Plain(public val string: String) : TextValue() {
        override fun get(context: Context): String = string
    }

    /** String resource, requires [Context] to get [String]. */
    @Parcelize
    public data class Resource(@StringRes public val resourceId: Int) : TextValue() {
        override fun get(context: Context): String = context.getString(resourceId)
    }

    public companion object {

        /** Empty [TextValue]. */
        public val EMPTY: TextValue = TextValue.Plain("")
    }
}

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public inline fun Context.getString(text: TextValue): String = text.get(this)

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public inline fun View.getString(text: TextValue): String = context.getString(text)

@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue"))
public typealias Text = TextValue

@Suppress("FunctionName")
@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue.Resource(resourceId)"))
public fun TextValue.Companion.Resource(@StringRes resourceId: Int): TextValue.Resource = TextValue.Resource(resourceId)

@Suppress("FunctionName")
@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue.Plain(string)"))
public fun TextValue.Companion.Plain(string: String): TextValue.Plain = TextValue.Plain(string)