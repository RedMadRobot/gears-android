# Redmadrobot Android KTX
[![License](https://img.shields.io/badge/license-MIT-green)][license]

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

- [core-ktx] - Extensions in addition to androidx core-ktx
- [fragment-args-ktx] - Delegates for safe dealing with fragments' arguments
- [lifecycle-livedata-ktx] - Extended set of extensions for dealing with `LiveData`
- [resources-ktx] - A set of extensions for accessing resources
- [viewbinding-ktx] - A set of extensions for dealing with ViewBinding

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
For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT][license]

[ktx]: https://developer.android.com/kotlin/ktx

[core-ktx]: core-ktx
[fragment-args-ktx]: fragment-args-ktx
[lifecycle-livedata-ktx]: lifecycle-livedata-ktx
[resources-ktx]: resources-ktx
[viewbinding-ktx]: viewbinding-ktx
[license]: LICENSE
