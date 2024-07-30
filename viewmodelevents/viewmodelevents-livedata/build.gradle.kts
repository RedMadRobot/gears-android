plugins {
    convention.library.android
}

description = "ViewModelEvents implemented via LiveData"

android {
    namespace = "$group.livedata"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.lifecycle.common)
    api(androidx.lifecycle.livedata.core)
    api(androidx.activity)
    api(androidx.annotation)
    api(androidx.fragment)
    api(project(":viewmodelevents:viewmodelevents-common"))

    testImplementation(stack.kotlin.test.junit5)
    testImplementation(stack.junit.jupiter.api)
    testImplementation(libs.assertj.core)
    testImplementation(libs.androidx.arch.core.testing)
    testRuntimeOnly(stack.junit.jupiter.engine)
}
