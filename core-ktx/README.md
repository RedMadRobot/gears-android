# core-ktx <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/core-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square)][mavenCentral] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

Kotlin extensions in addition to androidx core-ktx.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Extensions](#extensions)
  - [SharedPreferences](#sharedpreferences)
    - [Nullable Types](#nullable-types)
    - [Argument Key](#argument-key)
    - [Default Value](#default-value)
  - [Keyboard](#keyboard)
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
    implementation("com.redmadrobot.extensions:core-ktx:1.6.0-0")
}
```

## Extensions

### SharedPreferences

Extensions for `SharedPreferences`:
- `SharedPreferences.Editor.remove(vararg keys: String): SharedPreferences.Editor`

Also, you can use delegates to access values in `SharedPreferences`:
```kotlin
class ServerPreferencesStorage(
    private val preferences: SharedPreferences
) {
    companion object {
        private const val SERVER_IP = "server.ip"
        private const val SERVER_PORT = "server.port"
    }

    var serverIp: String by preferences.string(SERVER_IP)
    var serverPort: Int by preferences.int(SERVER_PORT)
    
    fun clear() {
        preferences.edit {
            remove(SERVER_IP, SERVER_PORT)
        }
    }
}
```

#### Nullable Types

For nullable types you can use functions with suffix `Nullable`:
```
string() -> stringNullable()
stringSet() -> stringSetNullable()
```

Primitive types can't be nullable, so there are no `intNullable()`, `floatNullable()`, etc.

#### Argument Key

By default, the key for getting argument from `SharedPreferences` is the property name.
You can override it with parameter `key` if you need:
```kotlin
var overrideKey by preferences.boolean("isOverrideKey")
```

#### Default Value

If you not assign any value to a property, will be returned default value on property reading.
Delegates of nullable types will always return `null` by default.
You can specify default value for non-nullable types with parameter `default`:
```kotlin
var messagesCount by preferences.int { 1 }
// or
var messagesCount by preferences.int(default = { 1 })
```

All delegates have `default` implementation by default:
- numeric primitives - `0`
- boolean - `false`
- String - `""` (empty string)
- String set - empty set

### Keyboard

Extension                             | Description
------------------------------------- | ------------------------------------------------------------
`View.isKeyboardVisible: Boolean`     | Returns `true` if keyboard is visible
`Activity.isKeyboardVisible: Boolean` | Returns `true` if keyboard is visible
`View.showKeyboard()`                 | Requests focus and shows keyboard for View if it is possible
`View.hideKeyboard()`                 | Hides keyboard if it is open
`Activity.hideKeyboard()`             | Hides keyboard if it is open

## Contributing
Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/core-ktx
[license]: ../LICENSE
