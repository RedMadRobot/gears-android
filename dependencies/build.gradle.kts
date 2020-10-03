plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.1")
}

gradlePlugin {
    plugins {
        register("dependencies") {
            id = "dependencies"
            implementationClass = "com.redmadrobot.build.dependencies.DependenciesPlugin"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
