# red_mad_robot Android KTX

[![License](https://img.shields.io/github/license/RedMadRobot/gears-android?style=flat-square)][license]

Missing Android KTX extensions.

> [!IMPORTANT]
> It is not a replacement of [Android KTX][ktx], it is just additional extensions and delegates that we found useful.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Modules](#modules)
- [Versioning](#versioning)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Modules

> [!TIP]
> Click on a badge to open library documentation.

- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][core-ktx] - Extensions in addition to androidx core-ktx
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-ktx?style=flat-square&label=fragment-ktx)][fragment-ktx] - A set of extensions in addition to androidx fragment-ktx
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-args-ktx?style=flat-square&label=fragment-args-ktx)][fragment-args-ktx] - Delegates for safe dealing with fragments' arguments
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/lifecycle-livedata-ktx?style=flat-square&label=lifecycle-livedata-ktx)][lifecycle-livedata-ktx] - Extended set of extensions for dealing with `LiveData`
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/resources-ktx?style=flat-square&label=resources-ktx)][resources-ktx] - A set of extensions for accessing resources
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/viewbinding-ktx?style=flat-square&label=viewbinding-ktx)][viewbinding-ktx] - A set of extensions for dealing with ViewBinding

## Versioning

Versions of modules contains two parts separated with `-` (dash).
First part is version of androidx library, and second - version of module starting from 0.
When first part of version increased, second part should be set to 0.

```
com.redmadrobot.extensions:fragment-args-ktx:2.2.0-0
```
- `2.2.0` - version of `androidx.fragment:fragment`
- `0` - version of extensions. First version of extensions for `fragment:2.2.0`

[ktx]: https://developer.android.com/kotlin/ktx

[core-ktx]: core-ktx
[fragment-ktx]: fragment-ktx
[fragment-args-ktx]: fragment-args-ktx
[lifecycle-livedata-ktx]: lifecycle-livedata-ktx
[resources-ktx]: resources-ktx
[viewbinding-ktx]: viewbinding-ktx
[license]: ../LICENSE
