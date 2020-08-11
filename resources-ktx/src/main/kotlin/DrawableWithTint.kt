@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.resources

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat.setTint
import androidx.core.graphics.drawable.DrawableCompat.wrap

/** Returns wrapped this drawable with specified [tint]. */
inline fun Drawable.withTint(@ColorInt tint: Int): Drawable {
    return wrap(this).mutate().also { setTint(it, tint) }
}
