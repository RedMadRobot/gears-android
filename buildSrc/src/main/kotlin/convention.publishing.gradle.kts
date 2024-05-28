import com.redmadrobot.build.dsl.*
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()

    pom {
        name.convention(project.name)
        description.convention(project.description)

        licenses {
            mit()
        }

        developers {
            developer(id = "osipxd", name = "Osip Fatkullin", email = "o.fatkullin@redmadrobot.com")
            developer(id = "sonulen", name = "Andrey Tolmachev", email = "a.tolmachev@redmadrobot.com")
        }

        setGitHubProject("RedMadRobot/gears-android")
    }
}

publishing {
    repositories {
        if (isRunningOnCi) githubPackages("RedMadRobot/gears-android")
    }
}
