// For some reason gradle.properties in this project doesn't affect its subprojects
val ktxGroup = group
subprojects { group = ktxGroup }
