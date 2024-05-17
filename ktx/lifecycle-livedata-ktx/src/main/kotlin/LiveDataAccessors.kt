package com.redmadrobot.extensions.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Provides delegate to read and write value in [MutableLiveData].
 * ```
 * import com.redmadrobot.extensions.lifecycle.provideDelegate
 *
 * val liveText = MutableLiveData("Initial text")
 * var text: String by liveText
 *
 * println(text)            // Initial text
 * text = "Changed text"
 * println(text)            // Changed text
 * println(liveText.value)  // Changed text
 * ```
 * @throws IllegalStateException on read when the `LiveData` doesn't contain value ot it is `null`.
 * @see requireValue
 */
public operator fun <T : Any> MutableLiveData<T>.provideDelegate(
    thisRef: Any?,
    property: KProperty<*>,
): ReadWriteProperty<Any?, T> {
    return object : ReadWriteProperty<Any?, T> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return requireValue()
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this@provideDelegate.value = value
        }
    }
}

/**
 * Provides delegate to read value from [LiveData].
 * ```
 * import com.redmadrobot.extensions.lifecycle.provideDelegate
 *
 * val liveText: LiveData<String> = MutableLiveData("Text")
 * val text: String by liveText
 *
 * println(text) // Initial text
 * ```
 * @throws IllegalStateException on read when the `LiveData` doesn't contain value ot it is `null`.
 * @see requireValue
 */
public operator fun <T : Any> LiveData<T>.provideDelegate(
    thisRef: Any?,
    property: KProperty<*>,
): ReadOnlyProperty<Any?, T> {
    return ReadOnlyProperty { _, _ -> requireValue() }
}

/**
 * Returns the value from this [LiveData].
 * @see provideDelegate
 */
@Suppress("NOTHING_TO_INLINE")
@Deprecated(
    message = "Import provideDelegate instead",
    replaceWith = ReplaceWith("provideDelegate"),
)
public inline operator fun <T : Any> LiveData<T>.getValue(thisRef: Any?, property: KProperty<*>): T = requireValue()

/**
 * Stores the value in this [LiveData].
 * @see provideDelegate
 */
@Suppress("NOTHING_TO_INLINE")
@Deprecated(
    message = "Import provideDelegate instead",
    replaceWith = ReplaceWith("provideDelegate"),
)
public inline operator fun <T : Any> MutableLiveData<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}
