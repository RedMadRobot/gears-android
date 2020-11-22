import com.redmadrobot.build.extension.credentialsExist
import com.redmadrobot.build.extension.isSnapshotVersion
import com.redmadrobot.build.extension.rmrBintray
import com.redmadrobot.build.kotlinCompile

plugins {
    val infrastructureVersion = "0.4.1"
    id("redmadrobot.android-library") version infrastructureVersion apply false
    id("redmadrobot.publish") version infrastructureVersion apply false

    id("redmadrobot.detekt") version infrastructureVersion
    id("com.github.ben-manes.versions") version "0.33.0"
    id("dependencies")
    `maven-publish`
}

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
