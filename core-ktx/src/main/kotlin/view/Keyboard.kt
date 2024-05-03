// Public API
@file:Suppress("NOTHING_TO_INLINE")

package com.redmadrobot.extensions.core.view

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.redmadrobot.extensions.core.findWindow

/** Returns `true` if keyboard is visible. Always returns `false` if View is detached.  */
@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public inline val View.isKeyboardVisible: Boolean
    get() = ViewCompat.getRootWindowInsets(this)
        ?.isVisible(WindowInsetsCompat.Type.ime()) == true

/** Returns `true` if keyboard is visible. */
@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public inline val Activity.isKeyboardVisible: Boolean
    get() = window.decorView.isKeyboardVisible

/** Requests focus and shows keyboard for [this] view if it is possible. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public inline fun View.showKeyboard() {
    val window = context.findWindow() ?: return

    WindowCompat.getInsetsController(window, this)
        .show(WindowInsetsCompat.Type.ime())
}

/** Hides keyboard for [this] view if it is open. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public inline fun View.hideKeyboard() {
    val window = context.findWindow() ?: return

    WindowCompat.getInsetsController(window, this)
        .hide(WindowInsetsCompat.Type.ime())
}

/** Hides keyboard for [this] activity if it is open. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public inline fun Activity.hideKeyboard() {
    window.decorView.hideKeyboard()
}
