// For some reason gradle.properties in this project doesn't affect its subprojects
val gearsGroup = group
subprojects { group = gearsGroup }
