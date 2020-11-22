# lifecycle-livedata-ktx <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/lifecycle-livedata-ktx"/>
[![Version](https://img.shields.io/bintray/v/redmadrobot-opensource/android/lifecycle-livedata-ktx?style=flat-square)][bintray] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

Extended set of extensions for dealing with `LiveData`.

> :information_source: Since Kotlin Coroutines 1.4.0 you can use StateFlow instead of LiveData to hold screen state in this case you don't want this library.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Usage](#usage)
  - [`LiveData` delegate](#livedata-delegate)
  - [Events Queue](#events-queue)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:
```groovy
repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.redmadrobot.extensions:lifecycle-livedata-ktx:2.2.0-0")
}
```

This library applies next dependencies, so you don't need to apply it manually:
- `androidx.lifecycle:lifecycle-livedata-ktx:2.2.0`
- `androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0`

Also, it depends on:
- `androidx.activity:activity:1.1.0`
- `androidx.annotation:annotation:1.1.0`
- `androidx.fragment:fragment:1.2.5`

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
val liveData = MutableLiveData<SomeViewState>(initialState)
var state: SomeViewState by liveData
```

### Events Queue

`LiveData` stores only last value, so it is unusable for storing events.
All events should be added to some kind of buffer and emitted on call `LiveData.observe`.
`EventQueue` fits these needs.

You can observe it like a normal `LiveData` and it will add to buffer all events you passed into:
```kotlin
data class MessageEvent(val message: String) : Event

val eventQueue = EventQueue()

eventQueue.offerEvent(MessageEvent("A"))
eventQueue.offerEvent(MessageEvent("B"))
eventQueue.observeForever { println(it) }
eventQueue.offerEvent(MessageEvent("C"))
```
```
MessageEvent(message=A)
MessageEvent(message=B)
MessageEvent(message=C)
```

| Extension | Description |
|-----------|-------------|
| <pre><code>Fragment.observe(<br>    liveData: EventQueue,<br>    onEvent: (Event) -> Unit<br>)</code></pre> | Shorter way to observe `LiveData` in a fragment |
| <pre><code>ComponentActivity.observe(<br>    liveData: EventQueue,<br>    onEvent: (Event) -> Unit<br>)</code></pre> | Shorter way to observe `LiveData` in an activity |

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[bintray]: https://bintray.com/redmadrobot-opensource/android/lifecycle-livedata-ktx
[license]: ../LICENSE
