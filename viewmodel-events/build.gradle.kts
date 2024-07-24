plugins {
    convention.detekt
    convention.library.ktx
}

// For some reason gradle.properties in this project doesn't affect its subprojects
val viewModelEventsGroup = group
subprojects { group = viewModelEventsGroup }

android {
    namespace = "$group.viewmodelevents"
}
