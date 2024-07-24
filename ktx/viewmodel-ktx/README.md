# EventQueue <GitHub path="RedMadRobot/EventQueue/tree/main"/>
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.eventqueue/eventqueue-livedata?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/EventQueue?style=flat-square)][license]

Queue to handle one-time events.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
  - [Flow implementation](#flow-implementation)
  - [LiveData implementation](#livedata-implementation)
  - [Best Practices](#best-practices)
      - [`EventsDispatcher` interface](#eventsdispatcher-interface)
      - [Shortcuts to send common events](#shortcuts-to-send-common-events)
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
    implementation("com.redmadrobot.eventqueue:eventqueue-flow:1.0.0")
    // or
    implementation("com.redmadrobot.eventqueue:eventqueue-livedata:1.0.0")

    // Compose extensions
    implementation("com.redmadrobot.eventqueue:eventqueue-compose:1.0.0")
}
```

## Usage

One-time events (or single events) are a common pattern to display messages or errors in UI.
`EventQueue` addresses the challenge of buffering and consuming one-time events:

- **Buffering:** When there are no subscribers to `EventQueue`, emitted events are stored in a buffer.
  All buffered events are then delivered sequentially as soon as you subscribe to the EventQueue
- **Consumption:** Each event is emitted only once.
  Thus, if you re-subscribe to the EventQueue, you will not receive any events that have already been consumed.

There are two implementations: via flow (recommended for use) and via livedata (deprecated).

### Flow implementation

This implementation utilizes `StateFlow` under the hood and provides the `flow` field to observe events.

```kotlin
data class MessageEvent(val message: String) : Event

val eventQueue = EventQueue()

eventQueue.offerEvent(MessageEvent("A"))
eventQueue.offerEvent(MessageEvent("B"))

// Observe
events.flow
    .onEach { onEvent(it) }
    .launchIn(scope)

eventQueue.offerEvent(MessageEvent("C"))
```

```bash
MessageEvent(message=A)
MessageEvent(message=B)
MessageEvent(message=C)
```

`EventQueue` can also be used with Jetpack Compose:

```kotlin
// Remember to add com.redmadrobot.eventqueue:eventqueue-compose dependency
@Composable
public fun Screen() {
    // We assume, ViewModel implementation has `events` field providing EventQueue instance
    val viewModel = viewModel<FeatureViewModel>()

    EventsEffect(viewModel.events) { event: Event ->
        when(event) {
            is MessageEvent -> println("Message: $event")
            is ErrorMessageEvent -> println("Error: $event")
        }
    }
}
```

That subscription emits values from `EventQueue` when the lifecycle is at least at `minActiveState` (`Lifecycle.State.STARTED` by default) state.
The emissions will be stopped when the lifecycle state falls below `minActiveState` state.

### LiveData implementation

This implementation utilizes `LiveData` under the hood and provides methods to observe events on the given lifecycle.

```kotlin
data class MessageEvent(val message: String) : Event

val eventQueue = EventQueue()

eventQueue.offerEvent(MessageEvent("A"))
eventQueue.offerEvent(MessageEvent("B"))
eventQueue.observeForever { println(it) }
eventQueue.offerEvent(MessageEvent("C"))
```

```bash
MessageEvent(message=A)
MessageEvent(message=B)
MessageEvent(message=C)
```

| Extension                                                                   | Description |
|-----------------------------------------------------------------------------|-------------|
| `Fragment.observe(liveData: EventQueue, onEvent: (Event) -> Unit)`          | Shorter way to observe `LiveData` in a fragment |
| `ComponentActivity.observe(liveData: EventQueue, onEvent: (Event) -> Unit)` | Shorter way to observe `LiveData` in an activity |

### Best Practices

Here you can find the patterns that we found useful to simplify usage of `EventQueue`.

#### `EventsDispatcher` interface

To simplify events sending, it is useful to declare the following interface:

```kotlin
/** Interface for dispatching events to an event queue. */
public interface EventsDispatcher {
    /** The event queue where events are dispatched. */
    public val events: EventQueue

    /** Offers the given [event] to be added to the event queue. */
    public fun offerEvent(event: Event) {
        events.offerEvent(event)
    }
}
```

That's it!
You can add this interface to any class you want to be able to send events.
For example, to your base `ViewModel`:

```kotlin
abstract class BaseViewModel : ViewModel(), EventsDispatcher {
    override val events = EventQueue()
}
```

Thus, all `ViewModel`s will be able to use `offerEvent(Event)` to send event:

```kotlin
class FeatureViewModel : BaseViewModel() {
    fun onError(message: String) = offerEvent(ErrorMessageEvent(message))
}
```

#### Shortcuts to send common events

It is useful to create extension-functions to send common events.
Let's imagine you have the following events:

```kotlin
data class MessageEvent(val message: String) : Event
data class ErrorMessageEvent(val message: String) : Event
```

To simplify sending of these events, you can create shortcuts.
It works best in combination with \[`EventDispatcher` interface\](add link here).

```kotlin
fun EventsDispatcher.showMessage(message: String) {
    offerEvent(MessageEvent(message))
}

fun EventsDispatcher.showError(message: String) {
    offerEvent(ErrorMessageEvent(message))
}
```

## Contributing

Merge requests are welcome.
For major changes, please open an issue first to discuss what you would like to change.

[mavenCentral]: https://search.maven.org/artifact/com.redmadrobot.eventqueue/eventqueue-livedata
[license]: ../LICENSE
