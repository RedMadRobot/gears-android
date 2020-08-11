package com.redmadrobot.extensions.lifecycle

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe

/**
 * Returns value from [LiveData] or throws [IllegalStateException].
 * @see LiveData.getValue
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <T : Any> LiveData<T>.requireValue(): T = checkNotNull(value)

/**
 * Shorter way to observe [LiveData] changes in a fragment using view lifecycle owner.
 * @see LiveData.observe
 */
inline fun <T> Fragment.observe(liveData: LiveData<T>, crossinline onChanged: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { onChanged(it) }
}

/**
 * Shorter way to observe [LiveData] changes in an activity.
 * @see LiveData.observe
 */
inline fun <T> ComponentActivity.observe(liveData: LiveData<T>, crossinline onChanged: (T) -> Unit) {
    liveData.observe(this) { onChanged(it) }
}
