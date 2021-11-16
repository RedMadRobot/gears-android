import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.3.6-1"
description = "Delegates for safe dealing with fragments' arguments"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.fragment)
}
