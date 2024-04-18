# lifecycle-livedata-ktx <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/lifecycle-livedata-ktx"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/lifecycle-livedata-ktx?style=flat-square)][mavenCentral] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

Extended set of extensions for dealing with `LiveData`.

> :information_source: Since Kotlin Coroutines 1.4.0 you can use StateFlow instead of LiveData to hold screen state in this case you don't want this library.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Usage](#usage)
  - [`LiveData` delegate](#livedata-delegate)
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
    implementation("com.redmadrobot.extensions:lifecycle-livedata-ktx:2.3.1-0")
}
```

This library applies next dependencies, so you don't need to apply it manually:
- `androidx.lifecycle:lifecycle-livedata-ktx:2.3.1`
- `androidx.lifecycle:lifecycle-livedata-core-ktx:2.3.1`

Also, it depends on:
- `androidx.activity:activity:1.2.3`
- `androidx.annotation:annotation:1.2.0`
- `androidx.fragment:fragment:1.3.5`

## Usage

| Extension | Description |
|-----------|-------------|
| <pre><code>LiveData\<T>.requireValue(): T</code></pre> | Get non-null value or throw exception |
| <pre><code>LiveData\<X>.mapDistinct(<br>    transform: (X) -> Y<br>): LiveData\<Y></code></pre> | Sequential call of `map` and `distinctUntilChanged` |
| <pre><code>Fragment.observe(<br>    liveData: LiveData\<T>,<br>    onChanged: (T) -> Unit<br>)</code></pre> | Shorter way to observe `LiveData` in a fragment |
| <pre><code>ComponentActivity.observe(<br>    liveData: LiveData\<T>,<br>    onChanged: (T) -> Unit<br>)</code></pre> | Shorter way to observe `LiveData` in an activity |

### `LiveData` delegate

To access value in LiveData you can use delegate:
```kotlin
import com.redmadrobot.extensions.lifecycle.provideDelegate

val liveData = MutableLiveData<SomeViewState>(initialState)
var state: SomeViewState by liveData
```

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/lifecycle-livedata-ktx
[license]: ../LICENSE
