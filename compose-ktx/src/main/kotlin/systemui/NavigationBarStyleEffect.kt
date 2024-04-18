@file:Suppress("FunctionNaming")
package com.redmadrobot.extensions.compose.systemui

import androidx.annotation.Discouraged
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Changes the color of navigation icons on [Event.ON_START], and reverts to the previous color on [Event.ON_STOP].
 * @param darkIcons Whether to use dark or light icons in navigation
 * @param withScrim Whether to add a scrim to the navigation for additional contrast of icons
 */
@Composable
public fun NavigationBarStyleEffect(
    darkIcons: Boolean,
    withScrim: Boolean = false,
) {
    NavigationBarStyleEffect(
        color = scrimOrTransparent(withScrim, darkIcons),
        darkIcons = darkIcons,
    )
}

/**
 * Changes the color of the navigation on [Event.ON_START], and reverts to the previous color on [Event.ON_STOP].
 * The color of the navigation icons will be automatically selected based on the provided color.
 * @param color The color to which the navigation will be recolored
 */
@Discouraged(
    "Instead of painting the navigation in the background color, it's worth it to enable Edge to Edge in the activity"
)
@Composable
public fun NavigationBarStyleEffect(color: Color) {
    NavigationBarStyleEffect(
        color = color,
        darkIcons = color.isLight(),
    )
}

/**
 * Changes the style of navigation on [Event.ON_START], and reverts to the previous style on [Event.ON_STOP].
 * @param color The color to which the navigation will be recolored
 * @param darkIcons Whether to use dark or light icons in navigation
 */
@Composable
public fun NavigationBarStyleEffect(
    color: Color,
    darkIcons: Boolean,
) {
    SystemBarsStyleEffect(
        statusBarStyle = SystemBarStyle.Unspecified,
        navigationBarStyle = rememberSystemBarStyle(color, darkIcons),
    )
}
