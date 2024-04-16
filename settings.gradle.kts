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
    "viewbinding-ktx",
    "textvalue",
    "textvalue-compose",
)

project(":textvalue").projectDir = File("textvalue/textvalue")
project(":textvalue-compose").projectDir = File("textvalue/textvalue-compose")
