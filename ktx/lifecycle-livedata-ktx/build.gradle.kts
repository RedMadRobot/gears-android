plugins {
    convention.library.ktx
}

version = "2.3.1-0"
description = "Extended set of extensions for dealing with LiveData"

dependencies {
    api(kotlin("stdlib"))
    api(androidx.lifecycle.common)
    api(androidx.lifecycle.livedata.core)
    api(androidx.activity)
    api(androidx.annotation)
    api(androidx.fragment)

    testImplementation(stack.kotlin.test.junit5)
    testImplementation(stack.junit.jupiter.api)
    testImplementation(libs.assertj.core)
    testImplementation(libs.androidx.arch.core.testing)
    testRuntimeOnly(stack.junit.jupiter.engine)
}
