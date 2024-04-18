plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
    convention.library.android
}

version = "1.0.0-0"
description = "Compose extensions"

android {
    namespace = "com.redmadrobot.compose-ktx"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.versions.compose.compiler.get()
    }
}

dependencies {
    api(projects.textvalue)
    api(androidx.compose.ui)
    api(androidx.annotation)
    api(androidx.compose.runtime)
    api(androidx.core)
    api(androidx.lifecycle.common)
}

