plugins {
    convention.library.android
}

description = "ViewModelEvents extensions for compose"

android {
    namespace = "$group.compose"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.versions.compose.compiler.get()
    }
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.lifecycle.runtime)
    api(androidx.compose.ui)
    api(androidx.compose.runtime)
    api(project(":viewmodelevents:viewmodelevents-flow"))
}
