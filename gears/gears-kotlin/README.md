# gears-kotlin

[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/gears-kotlin?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

A set of gears for Kotlin.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.redmadrobot.gears:gears-kotlin:<version>")
}
```

The library was developed and tested with Kotlin [2.0.0](https://github.com/JetBrains/kotlin/releases/tag/v2.0.0)

## Usage

| Gear                   | Description                                                                                  |
|:-----------------------|:---------------------------------------------------------------------------------------------|
| `T.applyIf`            | Applies the given block of modifications to the T if the condition is true                   |
| `T.applyIfNotNull`     | Applies the given block of modifications to the T if the value is not null                   |

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.


[mavenCentral]: https://central.sonatype.com/artifact/com.redmadrobot.gears/gears-kotlin
[license]: ../../LICENSE
