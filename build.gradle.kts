plugins {
    val infrastructureVersion = "0.2-SNAPSHOT"
    id("redmadrobot.android-library") version infrastructureVersion apply false
    id("redmadrobot.publish") version infrastructureVersion apply false

    id("redmadrobot.detekt") version infrastructureVersion
    id("dependencies")
}

subprojects {
    group = "com.redmadrobot.extensions"
}
