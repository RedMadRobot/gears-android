import com.redmadrobot.build.dependencies.androidx

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.3.2-0"
description = "Kotlin extensions in addition to androidx core-ktx"

dependencies {
    api(androidx.core.ktx)
}
