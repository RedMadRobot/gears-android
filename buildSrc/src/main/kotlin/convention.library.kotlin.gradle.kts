plugins {
    kotlin("jvm")
    id("convention.jvm")
    id("convention.publishing")
    id("convention.detekt")
}

kotlin {
    explicitApi()
}
