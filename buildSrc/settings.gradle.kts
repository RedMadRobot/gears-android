pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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
        gradlePluginPortal()
    }

    versionCatalogs {
        val version = "2024.08.01"
        create("rmr") {
            from("com.redmadrobot.versions:versions-redmadrobot:$version")
        }

        create("stack") {
            from("com.redmadrobot.versions:versions-stack:$version")
        }

        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
