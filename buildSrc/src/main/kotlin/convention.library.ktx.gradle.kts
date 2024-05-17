import com.redmadrobot.build.dsl.kotlinCompile

plugins {
    id("convention.library.android")
}

kotlinCompile {
    kotlinOptions {
        moduleName = "redmadrobot.${project.name}"
    }
}
