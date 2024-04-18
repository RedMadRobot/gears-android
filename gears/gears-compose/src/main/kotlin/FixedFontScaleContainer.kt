package com.redmadrobot.extensions.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

/**
 * A container that fixes the font scale, ignoring values,
 * that are set in the phone's system settings
 */
@Composable
public fun FixedFontScaleContainer(
    content: @Composable () -> Unit,
) {
    val fixedFontScaleDensity = Density(LocalDensity.current.density)
    CompositionLocalProvider(
        LocalDensity provides fixedFontScaleDensity,
        content = content,
    )
}

/**
 * A container that restricts the font scale, ignoring values,
 * that are set in the phone's system settings
 *
 * @param limit - the upper limit of font enlargement
 */
@Composable
public fun LimitedFontScaleContainer(
    limit: Float,
    content: @Composable () -> Unit,
) {
    val fontScale = LocalDensity.current.fontScale.coerceAtMost(limit)
    val fixedFontScaleDensity = Density(
        density = LocalDensity.current.density,
        fontScale = fontScale,
    )
    CompositionLocalProvider(
        LocalDensity provides fixedFontScaleDensity,
        content = content,
    )
}
