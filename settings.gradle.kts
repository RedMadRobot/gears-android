enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

rootProject.name = "ktx"

include(
    "core-ktx",
    "fragment-ktx",
    "fragment-args-ktx",
    "lifecycle-livedata-ktx",
    "resources-ktx",
    "resources-ktx:resources-common",
    "viewbinding-ktx",
)
