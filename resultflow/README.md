# ResultFlow

[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/resultflow?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

Utilities to deal with `Flow<Result<T>>`.

## Installation

Add the dependency:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.redmadrobot.gears:resultflow:<version>")
}
```

## Usage

> [!WARNING]
> The documentation is under construction

Tracking request status and handling error:

```kotlin
resultFlow { repository.fetchData() }
    .onEachState { resultState ->
        state = state.copy(loading = resultState.isLoading)
    }
    .foldEach(
        onSuccess = { handleContent(it) },
        onFailure = { showError(it) },
    )
```

## Contributing

Merge requests are welcome.
For major changes, open an issue first to discuss what you would like to change.


[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.gears/resultflow
[license]: ../LICENSE
