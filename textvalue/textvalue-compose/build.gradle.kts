plugins {
    convention.library.android
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
