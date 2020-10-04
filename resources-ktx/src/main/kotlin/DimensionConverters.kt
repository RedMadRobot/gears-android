@file:Suppress("NOTHING_TO_INLINE", "TooManyFunctions")

package com.redmadrobot.extensions.resources

import android.content.Context
import android.content.res.Resources
import kotlin.math.roundToInt

/**
 * Returns [dp] converted to PX and rounded.
 * @see dpToPxPrecisely
 */
public inline fun Context.dpToPx(dp: Int): Int = resources.dpToPx(dp)

/**
 * Returns [dp] converted to PX and rounded.
 * @see dpToPxPrecisely
 */
public inline fun Context.dpToPx(dp: Float): Int = resources.dpToPx(dp)

/**
 * Returns [dp] converted to PX and rounded.
 * @see dpToPxPrecisely
 */
public inline fun Resources.dpToPx(dp: Int): Int = (dp * displayMetrics.density).roundToInt()

/**
 * Returns [dp] converted to PX and rounded.
 * @see dpToPxPrecisely
 */
public inline fun Resources.dpToPx(dp: Float): Int = (dp * displayMetrics.density).roundToInt()

/**
 * Returns [dp] converted to PX.
 * @see dpToPx
 */
public inline fun Context.dpToPxPrecisely(dp: Int): Float = resources.dpToPxPrecisely(dp)

/**
 * Returns [dp] converted to PX.
 * @see dpToPx
 */
public inline fun Context.dpToPxPrecisely(dp: Float): Float = resources.dpToPxPrecisely(dp)

/**
 * Returns [dp] converted to PX.
 * @see dpToPx
 */
public inline fun Resources.dpToPxPrecisely(dp: Int): Float = dp * displayMetrics.density

/**
 * Returns [dp] converted to PX.
 * @see dpToPx
 */
public inline fun Resources.dpToPxPrecisely(dp: Float): Float = dp * displayMetrics.density

/** Returns [px] converted to DP. */
public inline fun Context.pxToDp(px: Int): Float = resources.pxToDp(px)

/** Returns [px] converted to DP. */
public inline fun Context.pxToDp(px: Float): Float = resources.pxToDp(px)

/** Returns [px] converted to DP. */
public inline fun Resources.pxToDp(px: Int): Float = px / displayMetrics.density

/** Returns [px] converted to DP. */
public inline fun Resources.pxToDp(px: Float): Float = px / displayMetrics.density
