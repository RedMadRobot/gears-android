plugins {
    convention.library.ktx
    id("kotlin-parcelize")
}

version = "1.3.1-0"
description = "A set of Kotlin extensions for accessing resources"

android {
    namespace = "com.redmadrobot.extensions.resources-ktx"
}

dependencies {
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
