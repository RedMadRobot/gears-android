// For some reason gradle.properties in this project doesn't affect its subprojects
val textValueGroup = group
subprojects { group = textValueGroup }
