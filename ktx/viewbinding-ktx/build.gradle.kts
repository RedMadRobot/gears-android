plugins {
    convention.library.ktx
}

version = "4.2.1-0"
description = "A set of Kotlin extensions for dealing with ViewBinding"

android {
    namespace = "$group.viewbinding"
    defaultConfig.consumerProguardFile("viewbinding.pro")
}

dependencies {
    api(kotlin("stdlib"))
    api(libs.androidx.viewbinding)
    api(androidx.fragment) // For ViewBindingDelegate
    api(androidx.lifecycle.common)
    api(androidx.lifecycle.livedata.core)
}
