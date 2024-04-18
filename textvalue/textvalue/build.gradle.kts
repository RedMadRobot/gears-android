plugins {
    convention.library.android
    id("kotlin-parcelize")
}

version = "1.3.1-0"
description = "TextValue is an abstraction over Android text"

dependencies {
    api(kotlin("stdlib"))
    api(androidx.annotation)
    compileOnly(androidx.compose.runtime)
}

android {
    namespace = "com.redmadrobot.textvalue"
}
