package com.redmadrobot.extensions.core.content

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty

/** @see SharedPreferences.string */
@Deprecated("Use 'string` instead", ReplaceWith("this.string(key, default)"))
public fun SharedPreferences.stringNullable(
    key: String? = null,
    default: () -> String,
): ReadWriteProperty<Any, String> = string(key, default)

/** @see SharedPreferences.string */
@Deprecated("Use 'stringSet` instead", ReplaceWith("this.stringSet(key, default)"))
public fun SharedPreferences.stringSetNullable(
    key: String? = null,
    default: () -> Set<String>,
): ReadWriteProperty<Any, Set<String>> = stringSet(key, default)
