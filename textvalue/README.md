# TextValue <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/textvalue"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/textvalue?style=flat-square)][mavenCentral] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

TextValue is an abstraction over Android text

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Wrapper `TextValue`](#wrapper-textvalue)
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
    implementation("com.redmadrobot.extensions:textvalue:1.3.1-0")

    // Compose extensions for textvalue
    implementation("com.redmadrobot.extensions:textvalue-compose:1.3.1-0")
}
```


## Wrapper `TextValue`

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

There are extensions to work with `TextValue` like with `StringRes`:

- `Context.getString(text: TextValue): String`
- `View.getString(text: TextValue): String`
- `Resources.getString(text: TextValue): String`

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/textvalue
[license]: ../LICENSE
