package com.redmadrobot.extensions.core.graphics

import android.graphics.*
import android.os.Build
import androidx.core.graphics.withSave

/**
 * Wrap the specified [block] in calls to [Canvas.save]/[Canvas.clipOutPath]
 * and [Canvas.restoreToCount].
 */
public inline fun Canvas.withClipOut(
    clipPath: Path,
    block: Canvas.() -> Unit,
) {
    withSave {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            clipOutPath(clipPath)
        } else {
            @Suppress("DEPRECATION")
            clipPath(clipPath, Region.Op.XOR)
        }
        block()
    }
}

/**
 * Wrap the specified [block] in calls to [Canvas.save]/[Canvas.clipOutRect]
 * and [Canvas.restoreToCount].
 */
public inline fun Canvas.withClipOut(
    clipRect: Rect,
    block: Canvas.() -> Unit,
) {
    withSave {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            clipOutRect(clipRect)
        } else {
            @Suppress("DEPRECATION")
            clipRect(clipRect, Region.Op.XOR)
        }
        block()
    }
}

/**
 * Wrap the specified [block] in calls to [Canvas.save]/[Canvas.clipOutRect]
 * and [Canvas.restoreToCount].
 */
public inline fun Canvas.withClipOut(
    clipRect: RectF,
    block: Canvas.() -> Unit,
) {
    withSave {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            clipOutRect(clipRect)
        } else {
            @Suppress("DEPRECATION")
            clipRect(clipRect, Region.Op.XOR)
        }
        block()
    }
}
