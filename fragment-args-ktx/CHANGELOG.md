## Unreleased

### Changes

- **Potentially breaking change!**
  Parameter `default` removed from `*Nullable` delegates.
  1. In case you want to return a non-null value by default, you should use the non-nullable version of delegate,
  2. If you want to return `null` it is the default behavior,
  3. If you want to return either `null` or non-null value depending on some condition you should do it in the place where you read the value from the delegate.

### Fixes

- Default value will be evaluated only if given key is not present in the bundle or value associated with the key is `null` (#31)

## [1.3.5-0] (2021-06-26)

### Dependencies

- kotlin-stdlib-jdk8 1.4.32 -> kotlin-stdlib 1.5.20 
- androidx.fragment 1.3.0 -> 1.3.5

## 1.3.0-0 (2021-03-01)

### Dependencies

- androidx.fragment 1.2.5 -> 1.3.0

## 1.2.5-0

First release


[1.3.5-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/core-ktx-v1.5.0-0...fragment-args-ktx-v1.3.5-0
