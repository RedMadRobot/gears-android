package com.redmadrobot.extensions.resources

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment

/**
 * Wrapper to work with dp row value, dimension resource id and px row value in the same way,
 * to make views more flexible.
 */
public sealed interface Dimension {

    /** Retrieves px [Int] using given [resources]. */
    @androidx.annotation.Px
    public fun getPixelOffset(resources: Resources): Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    /** Dimension resource, requires [Resources] to get px [Int]. */
    public data class Res(@DimenRes public val resourceId: Int) : Dimension {
        override fun getPixelOffset(resources: Resources): Int = resources.getDimensionPixelOffset(resourceId)
    }

    /** Plain dp value, requires [Resources] to get px [Int]. */
    public data class Dp(public val dp: Int) : Dimension {
        override fun getPixelOffset(resources: Resources): Int = resources.dpToPx(dp)
    }

    /** Plain px value. */
    public data class Px(@androidx.annotation.Px public val px: Int) : Dimension {
        override fun getPixelOffset(resources: Resources): Int = px
    }
}

public val Int.dp: Dimension.Dp get() = Dimension.Dp(this)

public val Int.px: Dimension.Px get() = Dimension.Px(this)

/**
 * Unwraps and returns a px value for the given [dimension].
 * @see Dimension
 */
@androidx.annotation.Px
public fun Resources.getDimensionPixelOffset(dimension: Dimension): Int = dimension.getPixelOffset(this)

/**
 * Unwraps and returns a px value for the given [dimension].
 * @see Dimension
 */
@androidx.annotation.Px
public fun Context.getDimensionPixelOffset(dimension: Dimension): Int = resources.getDimensionPixelOffset(dimension)

/**
 * Unwraps and returns a px value for the given [dimension].
 * @see Dimension
 */
@androidx.annotation.Px
public fun View.getDimensionPixelOffset(dimension: Dimension): Int = resources.getDimensionPixelOffset(dimension)

/**
 * Unwraps and returns a px value for the given [dimension].
 * @see Dimension
 */
@androidx.annotation.Px
public fun Fragment.getDimensionPixelOffset(dimension: Dimension): Int = resources.getDimensionPixelOffset(dimension)
