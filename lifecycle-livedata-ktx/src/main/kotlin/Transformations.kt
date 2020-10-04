package com.redmadrobot.extensions.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.map

/** Sequentially calls [map] and [distinctUntilChanged]. */
public inline fun <X, Y> LiveData<X>.mapDistinct(crossinline transform: (X) -> Y): LiveData<Y> {
    return map(transform).distinctUntilChanged()
}
