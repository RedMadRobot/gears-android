import com.redmadrobot.build.dependencies.androidx

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.0-rc1"
description = "Delegates for safe dealing with fragments' arguments"

dependencies {
    api(androidx.fragment)
}
