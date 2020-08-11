plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.0-rc1"
description = "A set of Kotlin extensions for dealing with ViewBinding"

android {
    defaultConfig.consumerProguardFile("viewbinding.pro")
}

dependencies {
    api(androidx.viewbinding)

    // For ViewBindingDelegate
    api(androidx.fragment)
    implementation(androidx.lifecycle.common)
    implementation(androidx.lifecycle.livedata_core)
}
