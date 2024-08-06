package com.redmadrobot.textvalue

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

/**
 * Unwraps and returns a string for the given [text].
 * @see TextValue
 */
@Composable
@ReadOnlyComposable
public fun stringResource(text: TextValue): String {
    val resources = resources()
    return resources.getString(text)
}

/**
 * A composable function that returns the [Resources]. It will be recomposed when [Configuration]
 * gets updated.
 */
@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}
