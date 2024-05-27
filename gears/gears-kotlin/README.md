# kotlin <GitHub path="RedMadRobot/gears-android/tree/main/gears/kotlin"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/kotlin?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

A set of gears for kotlin.

## Installation

Add the dependency:
```groovy
repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.redmadrobot.gears:gears-kotlin:<version>")
}
```

The library was developed and tested using:

> - `kotlin` [1.9.23](https://github.com/JetBrains/kotlin/releases/tag/v1.9.23)

> [!NOTE]
> These dependencies will be transiently included in your project.

## Usage

| Gear                   | Description                                                                                  |
|:-----------------------|:---------------------------------------------------------------------------------------------|
| `T.applyIf`            | Applies the given block of modifications to the T if the condition is true                   |
| `T.applyIfNotNull`     | Applies the given block of modifications to the T if the value is not null                   |

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.


[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.gears/gears-kotlin
[license]: ../LICENSE
