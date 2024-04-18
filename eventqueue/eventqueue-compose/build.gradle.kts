plugins {
    convention.library.android
}

version = "1.0.0-0"
description = "EventQueue extensions for compose"

android {
    namespace = "com.redmadrobot.eventqueue.compose"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.versions.compose.compiler.get()
    }
}


dependencies {
    api(kotlin("stdlib"))
    api(projects.eventqueueFlow)
    api(androidx.lifecycle.runtime)
    api(androidx.compose.runtime)
    api(androidx.compose.ui)
}
