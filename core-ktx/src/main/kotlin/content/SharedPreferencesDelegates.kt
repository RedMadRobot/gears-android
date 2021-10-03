package com.redmadrobot.extensions.core.content

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Creates a delegate to read and write [Boolean] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `false`.
 */
public fun SharedPreferences.boolean(
    key: String? = null,
    default: () -> Boolean = { false },
): ReadWriteProperty<Any, Boolean> {
    return delegate(
        key = key,
        fakeDefault = false,
        lazyDefault = default,
        getValue = SharedPreferences::getBoolean,
        setValue = SharedPreferences.Editor::putBoolean,
    )
}

/**
 * Creates a delegate to read and write [Float] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0.0`.
 */
public fun SharedPreferences.float(key: String? = null, default: () -> Float = { 0f }): ReadWriteProperty<Any, Float> {
    return delegate(
        key = key,
        fakeDefault = 0f,
        lazyDefault = default,
        getValue = SharedPreferences::getFloat,
        setValue = SharedPreferences.Editor::putFloat,
    )
}

/**
 * Creates a delegate to read and write [Int] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
public fun SharedPreferences.int(key: String? = null, default: () -> Int = { 0 }): ReadWriteProperty<Any, Int> {
    return delegate(
        key = key,
        fakeDefault = 0,
        lazyDefault = default,
        getValue = SharedPreferences::getInt,
        setValue = SharedPreferences.Editor::putInt,
    )
}

/**
 * Creates a delegate to read and write [Long] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `0`.
 */
public fun SharedPreferences.long(key: String? = null, default: () -> Long = { 0 }): ReadWriteProperty<Any, Long> {
    return delegate(
        key = key,
        fakeDefault = 0,
        lazyDefault = default,
        getValue = SharedPreferences::getLong,
        setValue = SharedPreferences.Editor::putLong,
    )
}

/**
 * Creates a delegate to read and write [String] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `""` (empty string).
 */
public fun SharedPreferences.string(
    key: String? = null,
    default: () -> String = { "" },
): ReadWriteProperty<Any, String> {
    return delegate(
        key = key,
        fakeDefault = "",
        lazyDefault = default,
        getValue = SharedPreferences::getString,
        setValue = SharedPreferences.Editor::putString,
    )
}

/**
 * Creates a delegate to read and write nullable [String] value in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
public fun SharedPreferences.stringNullable(key: String? = null): ReadWriteProperty<Any, String?> {
    return delegate(
        key = key,
        fakeDefault = null,
        lazyDefault = { null },
        getValue = SharedPreferences::getString,
        setValue = SharedPreferences.Editor::putString,
    )
}

/**
 * Creates a delegate to read and write set of [String] values in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is empty set.
 */
public fun SharedPreferences.stringSet(
    key: String? = null,
    default: () -> Set<String> = { emptySet() },
): ReadWriteProperty<Any, Set<String>> {
    return delegate(
        key = key,
        fakeDefault = emptySet(),
        lazyDefault = default,
        getValue = SharedPreferences::getStringSet,
        setValue = SharedPreferences.Editor::putStringSet,
    )
}

/**
 * Creates a delegate to read and write nullable set of [String] values in this [SharedPreferences] for the given [key].
 *
 * If the key is `null`, uses name of the property as the key.
 * Returns result of [default] function if there is no argument for the given key. Default value is `null`.
 */
public fun SharedPreferences.stringSetNullable(key: String? = null): ReadWriteProperty<Any, Set<String>?> {
    return delegate(
        key = key,
        fakeDefault = null,
        lazyDefault = { null },
        getValue = SharedPreferences::getStringSet,
        setValue = SharedPreferences.Editor::putStringSet,
    )
}

private inline fun <T> SharedPreferences.delegate(
    key: String?,
    fakeDefault: T,
    crossinline lazyDefault: () -> T,
    crossinline getValue: SharedPreferences.(key: String, defaultValue: T) -> T?,
    crossinline setValue: SharedPreferences.Editor.(key: String, value: T) -> SharedPreferences.Editor,
): ReadWriteProperty<Any, T> {
    return object : ReadWriteProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>): T {
            val finalKey = key ?: property.name
            return if (contains(finalKey)) {
                // fakeDefault will never be used and value should never be null, so we can cast value to T safely
                @Suppress("UNCHECKED_CAST")
                getValue(finalKey, fakeDefault) as T
            } else {
                lazyDefault()
            }
        }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            edit().setValue(key ?: property.name, value).apply()
        }
    }
}
