# fragment-args-ktx <GitHub path="RedMadRobot/gears-android/tree/main/ktx/fragment-args-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-args-ktx?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

Delegates for safe dealing with fragments' arguments.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Usage](#usage)
  - [Nullable Types](#nullable-types)
  - [Argument Key](#argument-key)
  - [Default Value](#default-value)
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
    implementation("com.redmadrobot.extensions:fragment-args-ktx:1.3.6-1")
}
```

## Usage

```kotlin
class FragmentWithArgs : Fragment() {

    companion object {
        fun newInstance(flag: Boolean, screenName: String? = null): Fragment {
            return FragmentWithArgs().apply { 
                this.someFlag = flag
                this.screenName = screenName
            }
        }
    }

    private var someFlag by arguments.boolean()
    private var screenName by arguments.stringNullable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("someFlag = $someFlag")
        println("screenName = $screenName")
    }
}
```

### Nullable Types

For nullable types you can use functions with suffix `Nullable`:
```
string() -> stringNullable()
intArray() -> intArrayNullable()
parcelableList() -> parcelableListNullable()
```

Primitive types can't be nullable, so there are no `intNullable()`, `floatNullable()`, etc.

### Argument Key

By default, the key for getting argument from bundle is the property name.
You can override it with parameter if you need:
```kotlin
val overrideKey by arguments.boolean("isOverrideKey")
```

### Default Value

If you not assign any value to a property, will be returned default value on property reading.
You can specify default value with parameter `default`:
```kotlin
val index by arguments.int { 1 }
// or
val index by arguments.int(default = { 1 })
```

> If you've not implemented `default` parameter, reading a value that wasn't written before will throw `IllegalStateException`.

## Contributing
Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/fragment-args-ktx
[license]: ../../LICENSE
