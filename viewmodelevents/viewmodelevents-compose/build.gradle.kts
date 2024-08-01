plugins {
    convention.library.android
    alias(stack.plugins.kotlin.compose)
}

description = "ViewModelEvents extensions for compose"

android {
    namespace = "$group.compose"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.lifecycle.runtime)
    api(androidx.compose.ui)
    api(androidx.compose.runtime)
    api(project(":viewmodelevents:viewmodelevents-flow"))
}
