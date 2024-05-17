plugins {
    convention.library.ktx
}

version = "1.6.0-2"
description = "Kotlin extensions in addition to androidx core-ktx"

android {
    namespace = "$group.core"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.core)
}
