import com.redmadrobot.build.dsl.isRunningOnCi
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

kotlinExtension.jvmToolchain(11)

// Treat all warnings as errors on CI
val warningsAsErrors = findProperty("warningsAsErrors") == "true" || isRunningOnCi

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions {
        allWarningsAsErrors = warningsAsErrors
    }
}
