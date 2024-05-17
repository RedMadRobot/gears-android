# fragment-ktx <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/fragment-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-ktx?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

A set of extensions in addition to androidx fragment-ktx.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Extensions](#extensions)
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
    implementation("com.redmadrobot.extensions:fragment-ktx:1.3.6-0")
}
```

## Extensions

Extensions for `Fragment`:

- `Fragment.addOnBackPressedCallback(enabled: Boolean = true, onBackPressed: OnBackPressedCallback.() -> Unit)`
  
  Create and add a new `OnBackPressedCallback` tied to `Fragment.viewLifecycleOwner` that calls `onBackPressed` in `OnBackPressedCallback.handleOnBackPressed`.

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/fragment-ktx
[license]: ../../LICENSE
