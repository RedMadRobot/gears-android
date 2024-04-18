# event queue <GitHub path="RedMadRobot/redmadrobot-android-ktx/tree/main/eventqueue"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/eventqueue/eventqueue-livedata?style=flat-square)][mavenCentral] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Installation](#installation)
- [Events Queue Flow](#events-queue-flow)
- [Events Queue Livedata](#events-queue-livedata)
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
    implementation("com.redmadrobot.extensions:eventqueue-livedata:1.0.0-0")
    // or
    implementation("com.redmadrobot.extensions:eventqueue-flow:1.0.0-0")

    // Compose extensions
    implementation("com.redmadrobot.extensions:eventqueue-compose:1.0.0-0")
}
```

## Events Queue Flow

The EventQueue class represents an event queue implemented via flow.
It allows you to add events to the queue and retrieve them as a data stream.

The library represents the EventsDispatcher interface, an event dispatcher that allows events to be sent to a queue.

The library also contains the MessageEvent and ErrorMessageEvent data classes, representing message and error message events respectively.
Also contains extension functions for EventsDispatcher to allow message and error messages to be sent through the Event Dispatcher:

```kotlin
public data class MessageEvent(val message: TextValue) : Event
public data class ErrorMessageEvent(val message: TextValue) : Event

public fun EventsDispatcher.showMessage(message: String) {
    offerEvent(MessageEvent(TextValue.Plain(message)))
}

public fun EventsDispatcher.showMessage(@StringRes resourceId: Int) {
    offerEvent(MessageEvent(TextValue.Resource(resourceId)))
}

public fun EventsDispatcher.showError(message: String) {
    offerEvent(ErrorMessageEvent(TextValue.Plain(message)))
}

public fun EventsDispatcher.showError(@StringRes resourceId: Int) {
    offerEvent(ErrorMessageEvent(TextValue.Resource(resourceId)))
}
```

## Events Queue LiveData

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

This library applies next dependencies, so you don't need to apply it manually:
- `androidx.lifecycle:lifecycle-livedata-ktx`
- `androidx.lifecycle:lifecycle-livedata-core-ktx`

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.extensions/eventqueue-livedata
[license]: ../LICENSE
