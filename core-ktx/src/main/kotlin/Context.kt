package com.redmadrobot.extensions.core

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.Window

/**
 * Finds [Activity] in [this] context.
 * @return The found `Activity` or `null` if `Activity` is not found.
 */
public tailrec fun Context.findActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
}

/**
 * Finds [Window] in [this] context.
 * @return The found `Window` or `null` if `Window` is not found.
 */
public tailrec fun Context.findWindow(): Window? {
    return when (this) {
        is Activity -> window
        is ContextWrapper -> baseContext.findWindow()
        else -> null
    }
}
