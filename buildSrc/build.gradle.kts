plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(rmr.infrastructure.publish)
    implementation(rmr.infrastructure.android)
    implementation(libs.publish.gradlePlugin)
    implementation(stack.gradle.android.cacheFixGradlePlugin)
    implementation(stack.kotlin.gradlePlugin)
    implementation(stack.detekt.gradlePlugin)
    implementation(libs.android.gradlePlugin)
}
