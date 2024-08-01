# ResultFlow

[![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/resultflow?style=flat-square)][mavenCentral]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

A couple of extensions to convert long operations into `Flow<Result<T>>`.
Allows handling such operations in functional way and provides single point to handle `Pending`, `Success` and `Failure` states.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Installation](#installation)
- [Usage](#usage)
- [Comparing to LCE](#comparing-to-lce)
- [Contributing](#contributing)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Installation

Add the dependency:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.redmadrobot.gears:resultflow:0.1.0")
}
```

## Usage

Use `resultFlow` function to turn long operations into `Flow<Result<T>>`:

```kotlin
resultFlow { respository.fetchData() }
```

Use `foldEach` to map result value or handle both `Success` and `Failure`:

```kotlin
resultFlow { respository.fetchData() }
    .foldEach(
        onSuccess = { handleContent(it) },
        onFailure = { showError(it) },
    )

// or

resultFlow { repository.fetchData() }
    .onEach { handleResult(it) }
```

Use `onEachState` to handle operation state ([ResultState](src/main/kotlin/ResultState.kt)) in single place:

```kotlin
resultFlow { repository.fetchData() }
    .onEachState { resultState ->
        // resultState could be Pending, Success, or Failure
        state = state.copy(loading = resultState.isPending)
    }
```

## Comparing to LCE

You may notice that the `ResultState` is similar to the pattern LCE (Loading, Content, Error).
Both of these patterns allow handling operations in a functional way,
both of them can be used to handle operation state in a single place.
However, these patterns have different purposes.
The `ResultState` purpose is to **indicate** an operation state, ignoring the result of the operation.
So, `ResultState.Success` doesn't contain any value compared to LCE's Content.
The result of the operation should be handled separately, using `onEach` or `foldEach` functions.

Here are more reasons why we don't use LCE:

- In most cases where we've used LCE, it was more convenient to handle `Loading` separately from the final result (`Content` or `Error`), and in some cases, we don't want to handle `Loading` at all.
  For such cases it is handy to have separate places to handle operation state and operation result.
- We found it useful to not expose `Loading` state as a return type, but isolate its usage inside the `onEachState` function which is called only when we need to handle this state.
- We don't always want to handle operations in a functional style.
  Especially if we need to call several operations one after another, it is more convenient to do it in an imperative style.
  In such cases we use `Result<T>` and it is simple to switch between `Result<T>` and `Flow<Result<T>>`.

## Contributing

Merge requests are welcome.
For major changes, open an issue first to discuss what you would like to change.


[mavenCentral]: https://central.sonatype.com/artifact/com.redmadrobot.gears/resultflow
[license]: ../LICENSE
