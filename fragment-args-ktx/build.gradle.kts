plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

version = "1.3.6-1"
description = "Delegates for safe dealing with fragments' arguments"

dependencies {
    implementation(kotlin("stdlib"))
    api(androidx.fragment)
}
