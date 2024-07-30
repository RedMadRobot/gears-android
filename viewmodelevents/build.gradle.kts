// For some reason gradle.properties in this project doesn't affect its subprojects
val viewModelEventsGroup = group
subprojects { group = viewModelEventsGroup }
