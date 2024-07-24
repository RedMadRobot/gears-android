plugins {
    convention.library.android
}

description = "EventQueue extensions for compose"

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
//    api(projects.eventqueueFlow)
    api(androidx.lifecycle.runtime)
}
