# TextValue <GitHub path="RedMadRobot/textvalue/tree/main/"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.textvalue/textvalue?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/textvalue?style=flat-square)][license]

TextValue is an abstraction allowing to work with a `String` and a string resource ID the same way.

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
    // Views version
    implementation("com.redmadrobot.textvalue:textvalue-common:<version>")

    // Compose extensions for textvalue
    implementation("com.redmadrobot.textvalue:textvalue-compose:<version>")
}
```

## Usage

**TextValue** is a wrapper to make it possible to work with plain `String` and `StringRes` in the same way.
It may be useful for cases when you want to fallback to `StringRes` if desired string value is `null`.

You can wrap `String` and `StringRes` with `TextValue` using `TextValue(String)`, `TextValue(Int)` or `TextValue(String?, Int))`, and use method `TextValue.get(Resource)` to retrieve `String`:

```kotlin
// in some place where we can't access Context
val errorMessage = TextValue(exception.message, defaultResourceId = R.string.unknown_error)
showMessage(errorMessage)

// in Activity, Fragment or View
fun showMessage(text: TextValue) {
    val messageText = text.get(resources)
    //...
}
```

`TextValue` also could be used with Jetpack Compose:

```kotlin
// in Composable functions
@Composable
fun Screen(title: TextValue) {
    // Remember to add com.redmadrobot.textvalue:textvalue-compose dependency
    Text(text = stringResource(title))
}
```

There are extensions to work with `TextValue` like with `StringRes`:

- `Context.getString(text: TextValue): String`
- `View.getString(text: TextValue): String`
- `Resources.getString(text: TextValue): String`

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.textvalue/textvalue
[license]: LICENSE
