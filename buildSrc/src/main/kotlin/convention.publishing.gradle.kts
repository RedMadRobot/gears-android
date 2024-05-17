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
            setGitHubProject("RedMadRobot/gears-android")

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
        if (isRunningOnCi) githubPackages("RedMadRobot/gears-android")
        if (isReleaseVersion && credentialsExist("ossrh")) ossrh()
    }
}

kotlinCompile {
    kotlinOptions {
        moduleName = "redmadrobot.${project.name}"
    }
}
