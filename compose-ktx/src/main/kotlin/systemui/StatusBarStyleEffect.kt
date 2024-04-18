@file:Suppress("FunctionNaming")
package com.redmadrobot.extensions.compose.systemui

import androidx.annotation.Discouraged
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle.Event

/**
 * When [Event.ON_START] changes the color of status bar icons, when [Event.ON_STOP] returns the previous color
 * @param darkIcons Whether to use dark or light icons in the status bar
 * @param withScrim Whether to add darkening/lightening of the status bar for additional contrast of icons
 */
@Composable
public fun StatusBarStyleEffect(
    darkIcons: Boolean,
    withScrim: Boolean = false,
) {
    StatusBarStyleEffect(
        color = scrimOrTransparent(withScrim, darkIcons),
        darkIcons = darkIcons,
    )
}

/**
 * When [Event.ON_START] changes the color of the status bar, when [Event.ON_STOP] returns the previous color.
 * The color of the status bar icons will be selected automatically depending on the passed color.
 * @param color The color in which the status bar will be recolored
 */
@Discouraged(
    "Instead of painting the status bar in the background color, it is worth enabling Edge to Edge in the activity"
)
@Composable
public fun StatusBarStyleEffect(color: Color) {
    StatusBarStyleEffect(
        color = color,
        darkIcons = color.isLight(),
    )
}

/**
 * When [Event.ON_START] changes the status bar style, when [Event.ON_STOP] returns the previous style
 * @param color The color in which the status bar will be repainted
 * @param darkIcons Whether to use dark or light icons in the status bar
 */
@Composable
public fun StatusBarStyleEffect(
    color: Color,
    darkIcons: Boolean,
) {
    SystemBarsStyleEffect(
        statusBarStyle = rememberSystemBarStyle(color, darkIcons),
        navigationBarStyle = SystemBarStyle.Unspecified,
    )
}
