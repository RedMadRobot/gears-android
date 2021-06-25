import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.2.0-1"
description = "A set of Kotlin extensions for accessing resources"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.annotation)
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
