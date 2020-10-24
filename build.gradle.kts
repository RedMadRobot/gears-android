import com.redmadrobot.build.kotlinCompile

plugins {
    val infrastructureVersion = "0.2"
    id("redmadrobot.android-library") version infrastructureVersion apply false
    id("redmadrobot.publish") version infrastructureVersion apply false

    id("redmadrobot.detekt") version infrastructureVersion
    id("com.github.ben-manes.versions") version "0.33.0"
    id("dependencies")
    `maven-publish`
}

subprojects {
    group = "com.redmadrobot.extensions"

    kotlinCompile {
        // Fix module-name conflicts with Android KTX
        kotlinOptions.freeCompilerArgs += listOf("-module-name", "redmadrobot.${project.name}")
    }
}

redmadrobot {
    // TODO: Investigate why default configuration is not valid
    configsDir.set(file("config"))
}

// TODO: Move to gradle-infrastructure
subprojects {
    apply(plugin = "maven-publish")

    val publishToBintray = "bintrayUsername" in properties && "bintrayPassword" in properties
    val isSnapshot = version.toString().endsWith("-SNAPSHOT")
    if (publishToBintray && !isSnapshot) {
        publishing {
            repositories {
                maven {
                    name = "bintray"
                    setUrl("https://api.bintray.com/maven/redmadrobot-opensource/android/${project.name}/")
                    credentials(PasswordCredentials::class)
                }
            }
        }
    }
}
