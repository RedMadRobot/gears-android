@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

/**
 * Returns a color associated with given [resId].
 * @see ContextCompat.getColor
 */
@ColorInt
public fun View.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

/**
 * Returns a color state list associated with given [resId].
 * @see ContextCompat.getColorStateList
 */
public fun View.getColorStateList(@ColorRes resId: Int): ColorStateList? =
    ContextCompat.getColorStateList(context, resId)

/**
 * Returns a dimension value associated with given [resId] in pixels.
 * @see Resources.getDimension
 */
public fun View.getDimension(@DimenRes resId: Int): Float = resources.getDimension(resId)

/**
 * Returns a drawable associated with given [resId],
 * or `null` if there is no such drawable.
 * @see AppCompatResources.getDrawable
 * @see getDrawableWithTint
 */
public fun View.getDrawable(@DrawableRes resId: Int): Drawable? = AppCompatResources.getDrawable(context, resId)

/**
 * Returns a drawable associated with given [resId],
 * or throws [IllegalArgumentException] if there is no such drawable.
 * @see getDrawable
 * @see getDrawableWithTint
 */
public fun View.requireDrawable(@DrawableRes resId: Int): Drawable = requireNotNull(getDrawable(resId))

/**
 * Returns a drawable associated with given [resId] and tinted with specified [tint] color,
 * or `null` if there is no such drawable.
 * @see getDrawable
 * @see withTint
 */
public fun View.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable? {
    return getDrawable(resId)?.withTint(tint)
}

/**
 * Returns a localized string associated with given [resId].
 * @see Resources.getString
 */
public fun View.getString(@StringRes resId: Int): String = resources.getString(resId)

/**
 * Returns a localized formatted string associated with given [resId],
 * substituting the [formatArgs] as defined in [String.format].
 * @see Resources.getString
 */
@Suppress("SpreadOperator") // Doesn't affect performance
public fun View.getString(@StringRes resId: Int, vararg formatArgs: Any): String =
    resources.getString(resId, *formatArgs)
