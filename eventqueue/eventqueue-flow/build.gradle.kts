plugins {
    convention.library.android
}

version = "1.0.0-0"
description = "EventQueue with LiveData"

android {
    namespace = "com.redmadrobot.eventqueue.flow"
}

dependencies {
    api(kotlin("stdlib"))

    api(projects.eventqueueCommon)
    api(projects.textvalue)
    api(androidx.lifecycle.common)
}
