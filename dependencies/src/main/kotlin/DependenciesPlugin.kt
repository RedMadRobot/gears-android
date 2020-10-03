package com.redmadrobot.build.dependencies

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        // Do nothing, just load dependencies to classpath
    }
}
