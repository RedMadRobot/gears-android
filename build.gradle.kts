import com.redmadrobot.build.extension.*
import com.redmadrobot.build.kotlinCompile

plugins {
    id("redmadrobot.root-project") version "0.8.1"
    id("com.github.ben-manes.versions") version "0.36.0"
    `maven-publish`
}

apply(plugin = "redmadrobot.detekt")

redmadrobot {
    android.minSdk = 14

    publishing {
        signArtifacts = !isRunningOnCi
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
        kotlinOptions.freeCompilerArgs += listOf("-module-name", "redmadrobot.${project.name}")
    }
}

subprojects {
    apply(plugin = "maven-publish")

    publishing {
        repositories {
            if (isRunningOnCi) githubPackages("RedMadRobot/redmadrobot-android-ktx")
            if (isReleaseVersion && credentialsExist("ossrh")) ossrh()
        }
    }
}
