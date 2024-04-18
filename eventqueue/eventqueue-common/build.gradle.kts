plugins {
    id("com.redmadrobot.kotlin-library")
    convention.publishing
    convention.detekt
}

version = "1.0.0-0"
description = "EventQueue common"

dependencies {
    api(kotlin("stdlib"))
}
