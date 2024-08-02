# gears-compose

[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/gears-compose?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

A set of gears for Jetpack Compose.

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
    google()
}

dependencies {
    implementation("com.redmadrobot.gears:gears-compose:<version>")
}
```

> [!NOTE]
>
> Dependencies:
> - `compose-ui` [1.6.8](https://developer.android.com/jetpack/androidx/releases/compose-ui#1.6.8)
> - `compose-runtime` [1.6.8](https://developer.android.com/jetpack/androidx/releases/compose-runtime#1.6.8)
>
> These dependencies will be transitively added to your project.

## Usage

|      Gear       | Description |
|:--------------------|:-----------|
| `FixedFontScaleContainer` | A container that fixes the font scale, ignoring values, that are set in the phone's system settings |

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.


[mavenCentral]: https://central.sonatype.com/artifact/com.redmadrobot.gears/gears-compose
[license]: ../../LICENSE
