plugins {
    convention.library.android
    alias(stack.plugins.kotlin.compose)
}

version = "0.1.0"
description = "A set of gears for Jetpack Compose"

android {
    namespace = "$group.compose"
}

dependencies {
    api(androidx.compose.ui)
    api(androidx.compose.runtime)
}
