pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

rootProject.name = "ktx"

includeBuild("dependencies")
include(
    "core-ktx",
    "fragment-args-ktx",
    "lifecycle-livedata-ktx",
    "resources-ktx",
    "viewbinding-ktx"
)
