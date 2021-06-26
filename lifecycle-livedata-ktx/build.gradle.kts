import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.assertj
import com.redmadrobot.build.dependencies.jetbrains
import com.redmadrobot.build.dependencies.junit

plugins {
    id("redmadrobot.android-library")
    id("redmadrobot.publish")
}

version = "2.3.1-0"
description = "Extended set of extensions for dealing with LiveData"

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.lifecycle.livedata_ktx)
    api(androidx.lifecycle.livedata_core_ktx)
    api(androidx.activity)
    api(androidx.annotation)
    api(androidx.fragment)
    testImplementation(jetbrains.kotlin.test_junit5)
    testImplementation(junit.jupiter.api)
    testImplementation(assertj.core)
    testImplementation(androidx.arch_core.testing)
    testRuntimeOnly(junit.jupiter.engine)
}
