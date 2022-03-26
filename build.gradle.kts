import com.redmadrobot.build.dsl.*

plugins {
    id("com.redmadrobot.android-config") version "0.15"
    id("com.redmadrobot.publish-config") version "0.15"
    id("com.redmadrobot.detekt") version "0.15"
    id("com.github.ben-manes.versions") version "0.39.0"
    `maven-publish`
}

redmadrobot {
    android.minSdk.set(14)

    publishing {
        signArtifacts.set(!isRunningOnCi)
        pom {
            setGitHubProject("RedMadRobot/redmadrobot-android-ktx")

            licenses {
                mit()
            }

            developers {
                developer(id = "osipxd", name = "Osip Fatkullin", email = "o.fatkullin@redmadrobot.com")
            }
        }
    }
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    group = "com.redmadrobot.extensions"

    kotlinCompile {
        // Fix module-name conflicts with Android KTX
        kotlinOptions.moduleName = "redmadrobot.${project.name}"
    }

    apply(plugin = "maven-publish")
    publishing {
        repositories {
            if (isRunningOnCi) githubPackages("RedMadRobot/redmadrobot-android-ktx")
            if (isReleaseVersion && credentialsExist("ossrh")) ossrh()
        }
    }
}
