import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

version = "4.2.1-0"
description = "A set of Kotlin extensions for dealing with ViewBinding"

android {
    defaultConfig.consumerProguardFile("viewbinding.pro")
}

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.viewbinding)
    api(androidx.fragment) // For ViewBindingDelegate
    implementation(androidx.lifecycle.common)
    implementation(androidx.lifecycle.livedata_core)
}
