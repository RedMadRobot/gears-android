// Public API
@file:Suppress("unused")

package com.redmadrobot.extensions.core.view

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/** Returns `true` if keyboard is visible. Always returns `false` if View is detached.  */
@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public val View.isKeyboardVisible: Boolean
    get() = ViewCompat.getRootWindowInsets(this)
        ?.isVisible(WindowInsetsCompat.Type.ime()) == true

/** Returns `true` if keyboard is visible. */
@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public val Activity.isKeyboardVisible: Boolean
    get() = window.decorView.isKeyboardVisible

/** Requests focus and shows keyboard for [this] view if it is possible. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public fun View.showKeyboard() {
    ViewCompat.getWindowInsetsController(this)
        ?.show(WindowInsetsCompat.Type.ime())
}

/** Hides keyboard for [this] view if it is open. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public fun View.hideKeyboard() {
    ViewCompat.getWindowInsetsController(this)
        ?.hide(WindowInsetsCompat.Type.ime())
}

/** Hides keyboard for [this] activity if it is open. */
@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
public fun Activity.hideKeyboard() {
    window.decorView.hideKeyboard()
}
