# Redmadrobot Android KTX
 [![Build Status](https://img.shields.io/github/workflow/status/RedMadRobot/redmadrobot-android-ktx/CI/main?style=flat-square)][ci] [![License](https://img.shields.io/github/license/RedMadRobot/redmadrobot-android-ktx?style=flat-square)][license]

Missing Android KTX extensions.

> :exclamation: It is not replacement of [Android KTX][ktx], it is just additional extensions and delegates that we found useful.

---
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


- [Modules](#modules)
- [Versioning](#versioning)
- [Contribution](#contribution)
- [License](#license)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Modules

Module's pages contain README with detailed description of module.

- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][core-ktx] - Extensions in addition to androidx core-ktx
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-ktx?style=flat-square&label=fragment-ktx)][fragment-ktx] - A set of extensions in addition to androidx fragment-ktx - deprecated
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/fragment-args-ktx?style=flat-square&label=fragment-args-ktx)][fragment-args-ktx] - Delegates for safe dealing with fragments' arguments - deprecated
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/lifecycle-livedata-ktx?style=flat-square&label=lifecycle-livedata-ktx)][lifecycle-livedata-ktx] - Extended set of extensions for dealing with `LiveData` - deprecated
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/resources-ktx?style=flat-square&label=resources-ktx)][resources-ktx] - A set of extensions for accessing resources
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/viewbinding-ktx?style=flat-square&label=viewbinding-ktx)][viewbinding-ktx] - A set of extensions for dealing with ViewBinding - deprecated
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][textvalue] - abstraction over Android text
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][eventqueue] - event queue implemented via flow/livedata
- [![Version](https://img.shields.io/maven-central/v/com.redmadrobot.extensions/core-ktx?style=flat-square&label=core-ktx)][compose-ktx] - Extensions for compose

## Versioning

Versions of modules contains two parts separated with `-` (dash).
First part is version of androidx library, and second - version of module starting from 0.
When first part of version increased, second part should be set to 0.

```
com.redmadrobot.extensions:fragment-args-ktx:2.2.0-0
```
- `2.2.0` - version of `androidx.fragment:fragment`
- `0` - version of extensions. First version of extensions for `fragment:2.2.0`

## Contribution

Merge requests are welcome.
For major changes, please open a [discussion][discussions] first to discuss what you would like to change.

## License

[MIT][license]

[ktx]: https://developer.android.com/kotlin/ktx

[core-ktx]: core-ktx
[fragment-ktx]: fragment-ktx
[fragment-args-ktx]: fragment-args-ktx
[lifecycle-livedata-ktx]: lifecycle-livedata-ktx
[resources-ktx]: resources-ktx
[viewbinding-ktx]: viewbinding-ktx
[ci]: https://github.com/RedMadRobot/redmadrobot-android-ktx/actions
[discussions]: https://github.com/RedMadRobot/redmadrobot-android-ktx/discussions
[textvalue]: textvalue
[eventqueue]: eventqueue
[compose-ktx]: compose-ktx
[license]: LICENSE
