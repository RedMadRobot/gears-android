plugins {
    convention.library.ktx
}

version = "1.3.6-0"
description = "A set of extensions in addition to androidx fragment-ktx"

dependencies {
    api(kotlin("stdlib"))
    api(androidx.fragment)
    api(androidx.activity)
    api(androidx.annotation)
}
