plugins {
    convention.library.android
}

description = "ViewModelEvents implemented via flow"

android {
    namespace = "$group.flow"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.lifecycle.common)
    api(project(":viewmodelevents:viewmodelevents-common"))
}
