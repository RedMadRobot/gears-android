import com.redmadrobot.build.dsl.*

plugins {
    alias(libs.plugins.gradle.android) apply false
    alias(stack.plugins.kotlin.android) apply false

    alias(rmr.plugins.android.config)
    alias(rmr.plugins.publish.config)
    alias(rmr.plugins.detekt)
    alias(stack.plugins.versions)
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
