@file:Suppress("ClassName")

package com.redmadrobot.build.dependencies

import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object jetbrains {
    object kotlin : Group("org.jetbrains.kotlin", version = "1.5.31") {
        val stdlib by this
        val test_junit5 by this
    }
}

object androidx {
    const val activity = "androidx.activity:activity:1.3.1"
    const val annotation = "androidx.annotation:annotation:1.2.0"
    const val viewbinding = "androidx.databinding:viewbinding:4.2.1"

    object appcompat : Group("androidx.appcompat", version = "1.3.1") {
        val resources by this
    }

    object core : Group("androidx.core", version = "1.6.0") {
        val ktx by this
    }

    object fragment : Group("androidx.fragment", version = "1.3.6") {
        val ktx by this
    }

    object lifecycle : Group("androidx.lifecycle", version = "2.3.1") {
        val common by this
        val livedata_ktx by this
        val livedata_core by this
        val livedata_core_ktx by this
    }

    object arch_core : Group("androidx.arch.core", version = "2.1.0") {
        val testing by this
    }
}

object assertj {
    const val core = "org.assertj:assertj-core:3.20.2"
}

object junit {
    object jupiter : Group("org.junit.jupiter", "junit-jupiter", version = "5.7.2") {
        val api by this
        val engine by this
    }
}

// <editor-fold defaultstate="collapsed" desc="Experimental API">
open class Group(
    group: String,
    name: String = group.substringAfterLast('.'),
    version: String,
    private val addPrefix: Boolean = true,
) : ReadOnlyProperty<Any?, String>, DefaultExternalModuleDependency(group, name, version) {

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return dep(property.name.replace('_', '-'))
    }

    private fun dep(module: String): String {
        val fullName = if (addPrefix) "$name-$module" else module
        return "$group:$fullName:$version"
    }
}
// </editor-fold>
