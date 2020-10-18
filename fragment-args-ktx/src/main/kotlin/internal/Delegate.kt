package com.redmadrobot.extensions.fragment.internal

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private typealias BundleGetter<T> = Bundle.(propertyKey: String) -> T
private typealias BundleSetter<T> = Bundle.(propertyKey: String, value: T) -> Unit

/** Creates a delegate to work with arguments. */
// Bundle needed to define extension scope.
@Suppress("unused")
internal inline fun <T> Bundle?.delegate(
    key: String?,
    crossinline getValue: BundleGetter<T>,
    crossinline setValue: BundleSetter<T>,
): ReadWriteProperty<Fragment, T> {
    return object : ReadWriteProperty<Fragment, T> {
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            // NOTE: When call getValue before setValue, app will crash.
            // So we need to initialize a bundle in both setter and getter.
            thisRef.initBundleIfNull()
            return thisRef.requireArguments().getValue(key ?: property.name)
        }

        override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
            thisRef.initBundleIfNull()
            thisRef.requireArguments().setValue(key ?: property.name, value)
        }

        private fun Fragment.initBundleIfNull() {
            if (arguments == null) arguments = Bundle()
        }
    }
}
