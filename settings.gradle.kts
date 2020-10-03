pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven {
            name = "rmrNexus"
            setUrl("https://nexus.redmadrobot.com/repository/android/")
            credentials(PasswordCredentials::class)
        }
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
