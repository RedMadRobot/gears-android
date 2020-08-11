plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "0.1"
description = "Kotlin extensions in addition to androidx core-ktx"

dependencies {
    api(androidx.core.ktx)
}
