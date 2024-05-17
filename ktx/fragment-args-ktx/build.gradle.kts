plugins {
    convention.library.ktx
}

version = "1.3.6-1"
description = "Delegates for safe dealing with fragments' arguments"

android {
    namespace = "$group.fragment.args"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.fragment)
}
