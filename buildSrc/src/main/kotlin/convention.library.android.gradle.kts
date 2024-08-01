plugins {
    id("com.android.library")
    kotlin("android")
    id("org.gradle.android.cache-fix")
    id("convention.jvm")
    id("convention.publishing")
    id("convention.detekt")
}

android {
    compileSdk = 34
    defaultConfig.minSdk = 19
}

kotlin {
    explicitApi()
}
