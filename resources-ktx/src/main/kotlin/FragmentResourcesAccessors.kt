@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Returns a color associated with given [resId].
 * @see ContextCompat.getColor
 */
@ColorInt
public fun Fragment.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(requireContext(), resId)

/**
 * Returns a color state list associated with given [resId].
 * @see ContextCompat.getColorStateList
 */
public fun Fragment.getColorStateList(@ColorRes resId: Int): ColorStateList? {
    return ContextCompat.getColorStateList(requireContext(), resId)
}

/**
 * Returns a drawable associated with given [resId],
 * or `null` if there is no such drawable.
 * @see AppCompatResources.getDrawable
 * @see getDrawableWithTint
 */
public fun Fragment.getDrawable(@DrawableRes resId: Int): Drawable? {
    return AppCompatResources.getDrawable(requireContext(), resId)
}

/**
 * Returns a drawable associated with given [resId],
 * or throws [IllegalArgumentException] if there is no such drawable.
 * @see getDrawable
 * @see getDrawableWithTint
 */
public fun Fragment.getDrawableWithTint(@DrawableRes resId: Int, @ColorInt tint: Int): Drawable? {
    return getDrawable(resId)?.withTint(tint)
}

/**
 * Returns a dimension value associated with given [resId] in pixels.
 * @see Resources.getDimension
 */
public fun Fragment.getDimension(@DimenRes resId: Int): Float = resources.getDimension(resId)

/**
 * Returns a dimension value associated with given [resId] in integer pixels.
 * A size conversion involves rounding the base value, and ensuring that
 * a non-zero base value is at least one pixel in size.
 * @see Resources.getDimensionPixelSize
 */
public fun Fragment.getDimensionPixelSize(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)

/**
 * Returns a dimension value associated with given [resId] in integer pixels.
 * An offset conversion involves simply truncating the base value to an integer.
 * @see Resources.getDimensionPixelOffset
 */
public fun Fragment.getDimensionPixelOffset(@DimenRes resId: Int): Int = resources.getDimensionPixelOffset(resId)
