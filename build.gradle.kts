import com.redmadrobot.build.dsl.*

plugins {
    id("redmadrobot.root-project") version "0.12.1"
    id("com.github.ben-manes.versions") version "0.39.0"
    `maven-publish`
}

apply(plugin = "redmadrobot.detekt")

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
