import com.redmadrobot.build.dependencies.androidx

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

dependencies {
    api(projects.resources.resourcesCommon)
    api(androidx.fragment)
    implementation(androidx.core)
    implementation(androidx.appcompat.resources)
}
