import com.redmadrobot.build.extension.credentialsExist
import com.redmadrobot.build.extension.isSnapshotVersion
import com.redmadrobot.build.extension.rmrBintray
import com.redmadrobot.build.kotlinCompile

plugins {
    id("redmadrobot.root-project") version "0.6"
    id("com.github.ben-manes.versions") version "0.36.0"
    id("dependencies")
    `maven-publish`
}

apply(plugin = "redmadrobot.detekt")

redmadrobot {
    android.minSdk = 14
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
            if (!isSnapshotVersion && credentialsExist("bintray")) rmrBintray(project.name)
        }
    }
}
