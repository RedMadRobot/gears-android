plugins {
    convention.library.android
}

version = "0.1.0"
description = "A set of gears for compose"

android {
    namespace = "$group.compose"

    defaultConfig.minSdk = 21

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.versions.compose.compiler.get()
    }
}

dependencies {
    api(androidx.compose.ui)
    api(androidx.compose.runtime)
}
