# Gears :gear:

[![Build Status](https://img.shields.io/github/actions/workflow/status/RedMadRobot/gears-android/main.yml?branch=main&style=flat-square)][ci]
[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

**Gears** – small libraries used in red_mad_robot to build awesome Android applications.
Gears could be used together or alone.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Libraries](#libraries)
- [Why Gears?](#why-gears)
- [Contribution](#contribution)
- [License](#license)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Libraries

### :gear: **[Gears](gears/)**

- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/gears-compose?style=flat-square&label=gears-compose)][gears-compose] — A set of gears for Jetpack Compose
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/gears-kotlin?style=flat-square&label=gears-kotlin)][gears-kotlin] — A set of gears for Kotlin

### :hammer_and_wrench: **[red_mad_robot Android KTX](ktx/)**

- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][core-ktx] — Extensions in addition to androidx core-ktx
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-ktx?style=flat-square&label=fragment-ktx)][fragment-ktx] — A set of extensions in addition to androidx fragment-ktx
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-args-ktx?style=flat-square&label=fragment-args-ktx)][fragment-args-ktx] — Delegates for safe dealing with fragments' arguments
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/lifecycle-livedata-ktx?style=flat-square&label=lifecycle-livedata-ktx)][lifecycle-livedata-ktx] — Extended set of extensions for dealing with `LiveData`
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/resources-ktx?style=flat-square&label=resources-ktx)][resources-ktx] — A set of extensions for accessing resources
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/viewbinding-ktx?style=flat-square&label=viewbinding-ktx)][viewbinding-ktx] — A set of extensions for dealing with ViewBinding

### :mag_right: **[ViewModelEvents](viewmodelevents/)**

- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/kotlin?style=flat-square&label=viewmodelevents-compose)][viewmodelevents-compose] — A set of extensions for dealing with ViewModelEvents inside `@Composable` functions
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/kotlin?style=flat-square&label=viewmodelevents-flow)][viewmodelevents-flow] — An implementation of ViewModelEvents via `Flow`
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/kotlin?style=flat-square&label=viewmodelevents-livedata)][viewmodelevents-livedata] — An implementation of ViewModelEvents via `LiveData`

### :hourglass_flowing_sand: **[Result Flow](resultflow/)** ![Version](https://img.shields.io/maven-central/v/com.redmadrobot.gears/resultflow?style=flat-square)

A couple of extensions to convert long operations into `Flow<Result<T>>`.

## Why Gears?

The goal of this mono-repository is to simplify the creation and publication of libraries.
These libraries, which we're calling "gears," are small but important parts of our tech stack that we want to share between our projects.

Libraries may be initially developed here and then moved out from this repository as part of their lifecycle.
Large libraries or those with unique build infrastructure should be moved into a separate repository.

## Contribution

Merge requests are welcome.
For major changes, open a [discussion][discussions] first to discuss what you would like to change.

## License

[MIT][license]

[core-ktx]: ktx/core-ktx/
[fragment-ktx]: ktx/fragment-ktx/
[fragment-args-ktx]: ktx/fragment-args-ktx/
[lifecycle-livedata-ktx]: ktx/lifecycle-livedata-ktx/
[resources-ktx]: ktx/resources-ktx/
[viewbinding-ktx]: ktx/viewbinding-ktx/
[license]: LICENSE

[gears-compose]: gears/gears-compose
[gears-kotlin]: gears/gears-kotlin

[viewmodelevents-compose]: viewmodelevents/viewmodelevents-compose/
[viewmodelevents-flow]: viewmodelevents/viewmodelevents-flow/
[viewmodelevents-livedata]: viewmodelevents/viewmodelevents-livedata/

[ci]: https://github.com/RedMadRobot/gears-android/actions?query=branch%3Amain++
[discussions]: https://github.com/RedMadRobot/gears-android/discussions
