plugins {
    convention.library.android
    alias(stack.plugins.kotlin.compose)
}

version = "0.1.0"
description = "A set of gears for compose"

android {
    namespace = "$group.compose"

    defaultConfig.minSdk = 21
}

dependencies {
    api(androidx.compose.ui)
    api(androidx.compose.runtime)
}
