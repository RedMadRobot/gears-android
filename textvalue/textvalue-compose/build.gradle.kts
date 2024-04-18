plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

version = "1.3.1-0"
description = "Compose extensions for TextValue"

dependencies {
    api(projects.textvalue)
    api(androidx.compose.ui)
}

android {
    namespace = "com.redmadrobot.textvalue.compose"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.versions.compose.compiler.get()
    }
}
