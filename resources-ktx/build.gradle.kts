import com.redmadrobot.build.dependencies.androidx

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

version = "1.3.1-0"
description = "A set of Kotlin extensions for accessing resources"

android {
    namespace = "com.redmadrobot.extensions.resources-ktx"
}

dependencies {
    api(projects.textvalue)
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
