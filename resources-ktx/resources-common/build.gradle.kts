import com.redmadrobot.build.dependencies.androidx
import com.redmadrobot.build.dependencies.jetbrains

plugins {
    id("com.redmadrobot.android-library")
    id("com.redmadrobot.publish")
}

dependencies {
    api(jetbrains.kotlin.stdlib)
    api(androidx.annotation)
}

android {
    namespace = "com.redmadrobot.extensions.resources.common"
}
