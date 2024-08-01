pluginManagement {
    repositories {
        google {
            content {
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
                includeGroupAndSubgroups("androidx")
            }
        }
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        google {
            content {
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
                includeGroupAndSubgroups("androidx")
            }
        }
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

rootProject.name = "gears"

include(
    ":ktx:core-ktx",
    ":ktx:fragment-ktx",
    ":ktx:fragment-args-ktx",
    ":ktx:lifecycle-livedata-ktx",
    ":ktx:resources-ktx",
    ":ktx:viewbinding-ktx",
    ":gears:gears-compose",
    ":gears:gears-kotlin",
    ":viewmodelevents:viewmodelevents-common",
    ":viewmodelevents:viewmodelevents-compose",
    ":viewmodelevents:viewmodelevents-flow",
    ":viewmodelevents:viewmodelevents-livedata",
    ":resultflow",
)
