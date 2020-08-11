plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "0.1"
description = "Extended set of extensions for dealing with LiveData"

dependencies {
    api(androidx.lifecycle.livedata_ktx)
    api(androidx.lifecycle.livedata_core_ktx)
    api(androidx.activity)
    api(androidx.annotation)
    api(androidx.fragment)
    testImplementation(assertj.core)
    testImplementation(androidx.arch_core.testing)
}
