import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.5.0-0"
description = "Kotlin extensions in addition to androidx core-ktx"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.core.ktx)
}
