plugins {
    convention.library.android
    id("kotlin-parcelize")
}

description = "TextValue is an abstraction over Android text"

android {
    namespace = "$group.common"
}

dependencies {
    api(kotlin("stdlib"))
    api(androidx.annotation)
    compileOnly(androidx.compose.runtime)
}
