import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "1.3.6-0"
description = "A set of extensions in addition to androidx fragment-ktx"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.fragment.ktx)
    api(androidx.activity)
    api(androidx.annotation)
}
