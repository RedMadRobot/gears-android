@file:Suppress("FunctionNaming")
package com.redmadrobot.extensions.compose.systemui

import android.app.Activity
import android.os.Build
import android.view.Window
import androidx.annotation.Discouraged
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * When [Event.ON_START] changes the system UI style, when [Event.ON_STOP] returns the previous style.
 * @param darkIcons Whether to use dark or light icons
 * @param withScrim Whether to add darkening/lightening for additional icon contrast
 */
@Composable
public fun SystemBarsStyleEffect(
    darkIcons: Boolean,
    withScrim: Boolean = false,
) {
    SystemBarsStyleEffect(
        color = scrimOrTransparent(withScrim, darkIcons),
        darkIcons = darkIcons,
    )
}

/**
 * At [Event.ON_START] changes the system UI style, at [Event.ON_STOP] returns the previous style
 * @param color The color in which the system bars will be repainted
 */
@Discouraged(
    "Instead of painting the system UI in the background color, it's worth including Edge to Edge in the activity."
)
@Composable
public fun SystemBarsStyleEffect(color: Color) {
    SystemBarsStyleEffect(
        color = color,
        darkIcons = color.isLight(),
    )
}

/**
 * When [Event.ON_START] changes the system UI style, when [Event.ON_STOP] returns the previous style
 * @param color The color in which the system bars will be repainted
 * @param darkIcons Whether to use dark or light icons in system bars
 */
@Composable
public fun SystemBarsStyleEffect(
    color: Color,
    darkIcons: Boolean,
) {
    val style = rememberSystemBarStyle(color = color, darkIcons = darkIcons)
    SystemBarsStyleEffect(
        statusBarStyle = style,
        navigationBarStyle = style
    )
}

/**
 * At [Event.ON_START] changes the system UI style, at [Event.ON_STOP] returns the previous style
 * @param statusBarStyle Status Bar Style
 * @param navigationBarStyle Navigation style
 */
@Composable
public fun SystemBarsStyleEffect(
    statusBarStyle: SystemBarStyle,
    navigationBarStyle: SystemBarStyle,
) {
    val window = (LocalContext.current as? Activity)?.window ?: return
    val statusBarColorChanger = rememberStatusBarColorChanger(window, statusBarStyle, navigationBarStyle)
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(statusBarColorChanger, lifecycle) {
        lifecycle.addObserver(statusBarColorChanger)
        onDispose { lifecycle.removeObserver(statusBarColorChanger) }
    }
}

@Composable
private fun rememberStatusBarColorChanger(
    window: Window,
    statusBarStyle: SystemBarStyle,
    navigationBarStyle: SystemBarStyle,
): SystemBarsStyleChanger {
    return remember(window, statusBarStyle, navigationBarStyle) {
        SystemBarsStyleChanger(window, statusBarStyle, navigationBarStyle)
    }
}

private class SystemBarsStyleChanger(
    private val window: Window,
    private val statusBarStyle: SystemBarStyle,
    private val navigationBarStyle: SystemBarStyle,
) : LifecycleEventObserver {

    private val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

    private var originalStatusStyle = SystemBarStyle.Unspecified
    private var originalNavigationStyle = SystemBarStyle.Unspecified

    override fun onStateChanged(source: LifecycleOwner, event: Event) {
        when (event) {
            Event.ON_START -> {
                if (statusBarStyle.isSpecified) setStatusBarAppearance()
                if (navigationBarStyle.isSpecified) setNavigationBarAppearance()
            }

            Event.ON_STOP -> {
                if (statusBarStyle.isSpecified) resetStatusBarAppearance()
                if (navigationBarStyle.isSpecified) resetNavigationBarAppearance()
            }

            else -> Unit // no-op
        }
    }

    // region Status Bar
    private fun setStatusBarAppearance() {
        originalStatusStyle = SystemBarStyle(
            color = Color(window.statusBarColor),
            darkIcons = windowInsetsController.isAppearanceLightStatusBars,
        )
        setStatusBarColor(statusBarStyle)
    }

    private fun resetStatusBarAppearance() {
        setStatusBarColor(originalStatusStyle)
    }

    private fun setStatusBarColor(style: SystemBarStyle) {
        windowInsetsController.isAppearanceLightStatusBars = style.darkIcons
        style.useColor { window.statusBarColor = it }
    }
    // endregion

    // region Navigation Bar
    private fun setNavigationBarAppearance() {
        originalNavigationStyle = SystemBarStyle(
            color = Color(window.navigationBarColor),
            darkIcons = windowInsetsController.isAppearanceLightNavigationBars,
        )
        setNavigationBarColor(navigationBarStyle)
    }

    private fun resetNavigationBarAppearance() {
        setNavigationBarColor(originalNavigationStyle)
    }

    @Suppress("BooleanPropertyNaming")
    private fun setNavigationBarColor(style: SystemBarStyle) {
        windowInsetsController.isAppearanceLightNavigationBars = style.darkIcons
        // If we're set to use dark icons, but our windowInsetsController call didn't
        // succeed (usually due to API level), we instead transform the color to maintain
        // contrast
        val failedToApplyDarkIcons = style.darkIcons && !windowInsetsController.isAppearanceLightNavigationBars
        style.useColor(scrimmed = failedToApplyDarkIcons) { color ->
            window.navigationBarColor = color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                window.navigationBarDividerColor = color
            }
        }
    }
    // endregion
}

/**
 * Creates a [SystemBarStyle] style with the given parameters.
 * @param color The color in which the system bar will be repainted
 * @param darkIcons Whether to use dark or light icons in the system bar
 * @see SystemBarsStyleEffect
 */
@Composable
public fun rememberSystemBarStyle(color: Color, darkIcons: Boolean): SystemBarStyle {
    return remember(color, darkIcons) { SystemBarStyle(color, darkIcons) }
}

/** @see rememberSystemBarStyle */
@Suppress("BooleanPropertyNaming")
@Immutable
public data class SystemBarStyle(
    val color: Color,
    val darkIcons: Boolean,
) {
    internal val isSpecified: Boolean
        get() = this !== Unspecified

    public companion object {
        public val Unspecified: SystemBarStyle = SystemBarStyle(
            color = Color.Unspecified,
            darkIcons = false,
        )
    }
}

private inline fun SystemBarStyle.useColor(scrimmed: Boolean = false, block: (Int) -> Unit) {
    if (color.isSpecified) {
        val contrastColor = if (scrimmed && color.alpha == 1f) {
            DarkScrim.compositeOver(color)
        } else {
            color
        }
        block(contrastColor.toArgb())
    }
}

@Suppress("MagicNumber")
internal fun Color.isLight(): Boolean = luminance() > 0.5f

internal fun scrimOrTransparent(withScrim: Boolean, darkIcons: Boolean): Color = when {
    withScrim && darkIcons -> LightScrim
    withScrim && !darkIcons -> DarkScrim
    else -> Color.Transparent
}

// https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/res/res/color/system_bar_background_semi_transparent.xml
// https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/res/remote_color_resources_res/values/colors.xml;l=67
internal val DarkScrim = Color(red = 0.1f, green = 0.1f, blue = 0.1f, alpha = 0.5f)

// https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/com/android/internal/policy/DecorView.java;drc=6ef0f022c333385dba2c294e35b8de544455bf19;l=142
internal val LightScrim = Color(red = 1.0f, green = 1.0f, blue = 1.0f, alpha = 0.9f)
