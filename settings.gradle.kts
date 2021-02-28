pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "redmadrobot") {
                useModule("com.redmadrobot.build:infrastructure:${requested.version}")
            }
        }
    }
}

rootProject.name = "ktx"

include(
    "core-ktx",
    "fragment-args-ktx",
    "lifecycle-livedata-ktx",
    "resources-ktx",
    "viewbinding-ktx"
)
