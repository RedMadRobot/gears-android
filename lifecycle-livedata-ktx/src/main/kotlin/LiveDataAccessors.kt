package com.redmadrobot.extensions.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

/**
 * Returns the value from this [LiveData].
 * @throws IllegalStateException when the `LiveData` doesn't contain value ot it is `null`.
 * @see requireValue
 */
@Suppress("NOTHING_TO_INLINE")
inline operator fun <T : Any> LiveData<T>.getValue(thisRef: Any?, property: KProperty<*>): T = requireValue()

/**
 * Stores the value in this [LiveData].
 * @see LiveData.setValue
 */
@Suppress("NOTHING_TO_INLINE")
inline operator fun <T : Any> MutableLiveData<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}
