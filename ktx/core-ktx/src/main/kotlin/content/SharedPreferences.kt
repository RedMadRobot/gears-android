package com.redmadrobot.extensions.core.content

import android.content.SharedPreferences

/** Calls [remove][SharedPreferences.Editor.remove] for each of specified [keys]. */
@Suppress("NOTHING_TO_INLINE")
public inline fun SharedPreferences.Editor.remove(vararg keys: String): SharedPreferences.Editor {
    for (key in keys) {
        remove(key)
    }
    return this
}
