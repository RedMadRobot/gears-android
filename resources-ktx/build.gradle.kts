plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "0.3"
description = "A set of Kotlin extensions for accessing resources"

dependencies {
    api(androidx.annotation)
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
