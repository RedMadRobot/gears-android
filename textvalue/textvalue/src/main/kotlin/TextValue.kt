package com.redmadrobot.textvalue

import android.content.Context
import android.content.res.Resources
import android.os.Parcelable
import android.view.View
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
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
@Immutable
public sealed interface TextValue : Parcelable {

    /** Retrieves [String] using the given [resources]. */
    public fun get(resources: Resources): String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    /** Plain string. */
    @Parcelize
    public data class Plain(public val string: String) : TextValue {
        override fun get(resources: Resources): String = string
    }

    /** String resource, requires [Resources] to get [String]. */
    @Parcelize
    public data class Resource(@StringRes public val resourceId: Int) : TextValue {
        override fun get(resources: Resources): String = resources.getString(resourceId)
    }

    public companion object {

        /** Empty [TextValue]. */
        public val EMPTY: TextValue = TextValue("")
    }
}

/** Creates [TextValue] from the given [resourceId]. */
public fun TextValue(@StringRes resourceId: Int): TextValue = TextValue.Resource(resourceId)

/** Creates [TextValue] from the given [string]. */
public fun TextValue(string: String): TextValue = TextValue.Plain(string)

/** Creates [TextValue] from the given [string], or from the [defaultResourceId] if string is `null`. */
public fun TextValue(string: String?, @StringRes defaultResourceId: Int): TextValue {
    return if (string != null) TextValue.Plain(string) else TextValue.Resource(defaultResourceId)
}

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public fun Context.getString(text: TextValue): String = resources.getString(text)

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public fun View.getString(text: TextValue): String = resources.getString(text)

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
public fun Resources.getString(text: TextValue): String = text.get(this)

/**
 * Returns TextValue itself if it is not `null`, or the [TextValue.EMPTY] otherwise.
 * @see TextValue
 */
public fun TextValue?.orEmpty(): TextValue = this ?: TextValue.EMPTY
