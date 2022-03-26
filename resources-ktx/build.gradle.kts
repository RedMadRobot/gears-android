import com.redmadrobot.build.dependencies.androidx

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
    id("kotlin-parcelize")
}

allprojects {
    version = "1.3.1-0"
    description = "A set of Kotlin extensions for accessing resources"
}

dependencies {
    api(projects.resourcesKtx.resourcesCommon)
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
