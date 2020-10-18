import com.redmadrobot.build.kotlinCompile

buildscript {
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }
}

plugins {
    val infrastructureVersion = "0.2"
    id("redmadrobot.android-library") version infrastructureVersion apply false
    id("redmadrobot.publish") version infrastructureVersion apply false

    id("redmadrobot.detekt") version infrastructureVersion
    id("com.github.ben-manes.versions") version "0.33.0"
    id("dependencies")
}

subprojects {
    group = "com.redmadrobot.extensions"

    kotlinCompile {
        kotlinOptions.freeCompilerArgs += listOf("-module-name", "redmadrobot.${project.name}")
    }
}
