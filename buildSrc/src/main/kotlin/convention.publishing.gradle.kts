import com.redmadrobot.build.dsl.*

plugins {
    id("com.redmadrobot.publish-config")
    id("com.redmadrobot.publish")
}

group = "com.redmadrobot.extensions"

redmadrobot {
    publishing {
        signArtifacts = !isRunningOnCi
        pom {
            setGitHubProject("RedMadRobot/redmadrobot-android-ktx")

            licenses {
                mit()
            }

            developers {
                developer(id = "osipxd", name = "Osip Fatkullin", email = "o.fatkullin@redmadrobot.com")
                developer(id = "sonulen", name = "Andrey Tolmachev", email = "sonulen@gmail.com")
            }
        }
    }
}

publishing {
    repositories {
        if (isRunningOnCi) githubPackages("RedMadRobot/redmadrobot-android-ktx")
        if (isReleaseVersion && credentialsExist("ossrh")) ossrh()
    }
}

kotlinCompile {
    kotlinOptions {
        moduleName = "redmadrobot.${project.name}"
    }
}
