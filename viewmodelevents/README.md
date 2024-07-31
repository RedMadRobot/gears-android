# ViewModelEvents
[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.viewmodelevents/viewmodelevents-common?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

The entity to handle one-time viewModel events.

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
    implementation("com.redmadrobot.viewmodelevents:viewmodelevents-flow:<version>")
    // or
    implementation("com.redmadrobot.viewmodelevents:viewmodelevents-livedata:<version>")

    // Compose extensions
    implementation("com.redmadrobot.viewmodelevents:viewmodelevents-compose:<version>")
}
```

## Usage

One-time events (or single events) are a common pattern to display messages or errors in UI.
`ViewModelEvents` addresses the challenge of buffering and consuming one-time events:

- **Buffering:** When there are no subscribers to `ViewModelEvents`, emitted events are stored in a buffer.
  All buffered events are then delivered sequentially as soon as you subscribe to the ViewModelEvents
- **Consumption:** Each event is emitted only once.
  Thus, if you re-subscribe to the ViewModelEvents, you will not receive any events that have already been consumed.

There are two implementations: via flow (recommended for use) and via livedata (deprecated).

### Flow implementation

This implementation utilizes `StateFlow` under the hood and provides the `flow` field to observe events.

```kotlin
data class MessageEvent(val message: String) : Event

val viewModelEvents = ViewModelEvents()

viewModelEvents.offerEvent(MessageEvent("A"))
viewModelEvents.offerEvent(MessageEvent("B"))

// Observe
events.flow
    .onEach { onEvent(it) }
    .launchIn(scope)

viewModelEvents.offerEvent(MessageEvent("C"))
```

```kotlin
MessageEvent(message="A")
MessageEvent(message="B")
MessageEvent(message="C")
```

`ViewModelEvents` can also be used with Jetpack Compose:

```kotlin
// Remember to add viewmodelevents-compose dependency
@Composable
public fun Screen() {
    // We assume, ViewModel implementation has `events` field providing ViewModelEvents instance
    val viewModel = viewModel<FeatureViewModel>()

    ViewModelEventsEffect(viewModel.events) { event: Event ->
        when(event) {
            is MessageEvent -> println("Message: $event")
            is ErrorMessageEvent -> println("Error: $event")
        }
    }
}
```

That subscription emits values from `ViewModelEvents` when the lifecycle is at least at `minActiveState` (`Lifecycle.State.STARTED` by default).
Emission stops when the lifecycle state falls below the `minActiveState` state.

### LiveData implementation

This implementation utilizes `LiveData` under the hood and provides methods to observe events on the given lifecycle.

```kotlin
data class MessageEvent(val message: String) : Event

val viewModelEvents = ViewModelEvents()

viewModelEvents.offerEvent(MessageEvent("A"))
viewModelEvents.offerEvent(MessageEvent("B"))
viewModelEvents.observeForever { println(it) }
viewModelEvents.offerEvent(MessageEvent("C"))
```

```bash
MessageEvent(message=A)
MessageEvent(message=B)
MessageEvent(message=C)
```

| Extension                                                                   | Description |
|-----------------------------------------------------------------------------|-------------|
| `Fragment.observe(liveData: ViewModelEvents, onEvent: (Event) -> Unit)`     | Shorter way to observe `LiveData` in a fragment |
| `ComponentActivity.observe(liveData: ViewModelEvents, onEvent: (Event) -> Unit)` | Shorter way to observe `LiveData` in an activity |

### Best Practices

Here you can find the patterns that we found useful to simplify usage of `ViewModelEvents`.

#### `EventsDispatcher` interface

To simplify events sending, it is useful to declare the following interface:

```kotlin
/** Interface for ViewModel events dispatching. */
public interface EventsDispatcher {
    public val events: ViewModelEvents

    /** Offers the given [event] to be added to the ViewModel events. */
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
    override val events = ViewModelEvents()
}
```

Thus, all `ViewModel`s will be able to use `offerEvent(Event)` to send events:

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
It works best with the [`EventsDispatcher` interface](#eventsdispatcher-interface).

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

[mavenCentral]: https://central.sonatype.com/artifact/com.redmadrobot.viewmodelevents/viewmodelevents-common
[license]: ../LICENSE
