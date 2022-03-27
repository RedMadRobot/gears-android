@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.content.Context
import android.content.res.Resources
import android.os.Parcelable
import android.view.View
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

/**
 * Wrapper to make it possible to work with plain [String] and [StringRes] in the same way.
 *
 * ```
 *  // in some place where we can't access Context
 *  val errorMessage = TextValue(exception.message, defaultResourceId= R.string.unknown_error)
 *  showMessage(errorMessage)
 *
 *  // in Activity, Fragment or View
 *  val messageText = getString(message)
 * ```
 */
public sealed class TextValue : Parcelable {

    /** Retrieves [String] using the given [context]. */
    @Deprecated("Use get with Resources instead.", ReplaceWith("this.get(context.resources)"))
    public fun get(context: Context): String = get(context.resources)

    /** Retrieves [String] using the given [resources]. */
    public abstract fun get(resources: Resources): String

    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int

    /** Plain string. */
    @Parcelize
    public data class Plain(public val string: String) : TextValue() {
        override fun get(resources: Resources): String = string
    }

    /** String resource, requires [Resources] to get [String]. */
    @Parcelize
    public data class Resource(@StringRes public val resourceId: Int) : TextValue() {
        override fun get(resources: Resources): String = resources.getString(resourceId)
    }

    public companion object {

        /** Empty [TextValue]. */
        public val EMPTY: TextValue = TextValue("")
    }
}

/** Creates [TextValue] from the given [resourceId]. */
public inline fun TextValue(@StringRes resourceId: Int): TextValue = TextValue.Resource(resourceId)

/** Creates [TextValue] from the given [string]. */
public inline fun TextValue(string: String): TextValue = TextValue.Plain(string)

/** Creates [TextValue] from the given [string], or from the [defaultResourceId] if string is `null`. */
public inline fun TextValue(string: String?, @StringRes defaultResourceId: Int): TextValue {
    return if (string != null) TextValue.Plain(string) else TextValue.Resource(defaultResourceId)
}

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public inline fun Context.getString(text: TextValue): String = resources.getString(text)

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public inline fun View.getString(text: TextValue): String = resources.getString(text)

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public inline fun Resources.getString(text: TextValue): String = text.get(this)

@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue"))
public typealias Text = TextValue

@Suppress("FunctionName")
@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue(resourceId)"))
public fun TextValue.Companion.Resource(@StringRes resourceId: Int): TextValue.Resource = TextValue.Resource(resourceId)

@Suppress("FunctionName")
@Deprecated("Text renamed to TextValue for compatibility with compose", ReplaceWith("TextValue(string)"))
public fun TextValue.Companion.Plain(string: String): TextValue.Plain = TextValue.Plain(string)
