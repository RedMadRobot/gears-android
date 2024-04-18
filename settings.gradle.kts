enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        val version = "2024.04.10"
        create("rmr") {
            from("com.redmadrobot.versions:versions-redmadrobot:$version")
        }
        create("androidx") {
            from("com.redmadrobot.versions:versions-androidx:$version")
        }
        create("stack") {
            from("com.redmadrobot.versions:versions-stack:$version")
        }
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
    "compose-ktx",
    "textvalue",
    "textvalue-compose",
    "eventqueue-common",
    "eventqueue-livedata",
    "eventqueue-flow",
    "eventqueue-compose",
)

project(":textvalue").projectDir = File("textvalue/textvalue")
project(":textvalue-compose").projectDir = File("textvalue/textvalue-compose")
project(":eventqueue-common").projectDir = File("eventqueue/eventqueue-common")
project(":eventqueue-livedata").projectDir = File("eventqueue/eventqueue-livedata")
project(":eventqueue-flow").projectDir = File("eventqueue/eventqueue-flow")
project(":eventqueue-compose").projectDir = File("eventqueue/eventqueue-compose")
