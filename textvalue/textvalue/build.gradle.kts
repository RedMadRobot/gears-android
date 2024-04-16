import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
    id("kotlin-parcelize")
}

version = "1.3.1-0"
description = "TextValue is an abstraction over Android text"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.annotation)
    compileOnly(androidx.compose.runtime)
}

android {
    namespace = "com.redmadrobot.textvalue"
}
