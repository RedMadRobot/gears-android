plugins {
    convention.library.android
    alias(stack.plugins.kotlin.compose)
}

description = "Compose extensions for TextValue"

dependencies {
    api(project(":textvalue:textvalue-common"))
    api(androidx.compose.ui)
}

android {
    namespace = "$group.compose"

    buildFeatures {
        compose = true
    }
}
