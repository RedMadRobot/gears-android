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
    "viewbinding-ktx",
)
