plugins {
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    //noinspection UseTomlInstead
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-rules-libraries:1.23.6")
    //noinspection UseTomlInstead
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.6")
}
