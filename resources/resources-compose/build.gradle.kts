import com.redmadrobot.build.dependencies.androidx

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

dependencies {
    api(projects.resources.resourcesCommon)
    api(androidx.compose.ui)
}

android {
    namespace = "com.redmadrobot.extensions.resources.compose"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = androidx.compose.version
    }
}
