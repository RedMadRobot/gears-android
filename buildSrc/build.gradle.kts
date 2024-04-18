plugins {
    `kotlin-dsl`
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(rmr.infrastructure.publish)
    implementation(rmr.infrastructure.android)
    implementation(stack.gradle.android.cacheFixGradlePlugin)
    implementation(stack.kotlin.gradlePlugin)
    implementation(stack.detekt.gradlePlugin)
    implementation(libs.gradle)
}
