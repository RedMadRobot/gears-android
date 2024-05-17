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
public inline fun View.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

/**
 * Returns a color state list associated with given [resId].
 * @see ContextCompat.getColorStateList
 */
public inline fun View.getColorStateList(@ColorRes resId: Int): ColorStateList? =
    ContextCompat.getColorStateList(context, resId)

/**
 * Returns a dimension value associated with given [resId] in pixels.
 * @see Resources.getDimension
 */
public inline fun View.getDimension(@DimenRes resId: Int): Float = resources.getDimension(resId)

/**
 * Returns a dimension value associated with given [resId] in integer pixels.
 * A size conversion involves rounding the base value, and ensuring that
 * a non-zero base value is at least one pixel in size.
 * @see Resources.getDimensionPixelSize
 */
public inline fun View.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)

/**
 * Returns a dimension value associated with given [resId] in integer pixels.
 * An offset conversion involves simply truncating the base value to an integer.
 * @see Resources.getDimensionPixelOffset
 */
public inline fun View.getDimensionPixelOffset(@DimenRes resId: Int): Int = resources.getDimensionPixelOffset(resId)

/**
 * Returns a drawable associated with given [resId],
 * or `null` if there is no such drawable.
 * @see AppCompatResources.getDrawable
 * @see getDrawableWithTint
 */
public inline fun View.getDrawable(@DrawableRes resId: Int): Drawable? = AppCompatResources.getDrawable(context, resId)

/**
 * Returns a drawable associated with given [resId],
 * or throws [IllegalArgumentException] if there is no such drawable.
 * @see getDrawable
 * @see getDrawableWithTint
 */
public inline fun View.requireDrawable(@DrawableRes resId: Int): Drawable = requireNotNull(getDrawable(resId))

/**
 * Returns a drawable associated with given [resId] and tinted with specified [tint] color,
 * or `null` if there is no such drawable.
 * @see getDrawable
 * @see withTint
 */
public inline fun View.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable? {
    return getDrawable(resId)?.withTint(tint)
}

/**
 * Returns a localized string associated with given [resId].
 * @see Resources.getString
 */
public inline fun View.getString(@StringRes resId: Int): String = resources.getString(resId)

/**
 * Returns a localized formatted string associated with given [resId],
 * substituting the [formatArgs] as defined in [String.format].
 * @see Resources.getString
 */
public inline fun View.getString(@StringRes resId: Int, vararg formatArgs: Any): String =
    resources.getString(resId, *formatArgs)

/**
 * Returns a string associated with given [resId] and pluralized according to [quantity].
 * @see Resources.getQuantityString
 */
public inline fun View.getQuantityString(@PluralsRes resId: Int, quantity: Int): String {
    return resources.getQuantityString(resId, quantity)
}

/**
 * Returns a formatted string associated with given [resId] and pluralized according to [quantity],
 * substituting the [formatArgs] as defined in [String.format].
 * @see Resources.getQuantityString
 */
public inline fun View.getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg formatArgs: Any): String {
    return resources.getQuantityString(resId, quantity, *formatArgs)
}
