## Unreleased

## [1.3.6-1] (2021-11-16)

### Changes

- **Breaking change!**
  Removed `default` parameters implementation from delegates to prevent mistakes when a value was not written before reading (#37).\
  `IllegalStateException` will be thrown by default if you're trying to read a value that wasn't written before.
  If you need to return the default value instead, specify the `default` parameter manually.
- Added parameter `key: String` to `default` lambda. 

## [1.3.6-0] (2021-10-02)

### Changes

- **Potentially breaking change!**
  Parameter `default` removed from `*Nullable` delegates.
  1. In case you want to return a non-null value by default, you should use the non-nullable version of delegate,
  2. If you want to return `null` it is the default behavior,
  3. If you want to return either `null` or non-null value depending on some condition you should do it in the place where you read the value from the delegate.

### Fixes

- Default value will be evaluated only if given key is not present in the bundle or value associated with the key is `null` (#31)

### Dependencies

- androidx.fragment 1.3.5 -> 1.3.6
- kotlin-stdlib 1.5.20 -> 1.5.31

## [1.3.5-0] (2021-06-26)

### Dependencies

- kotlin-stdlib-jdk8 1.4.32 -> kotlin-stdlib 1.5.20 
- androidx.fragment 1.3.0 -> 1.3.5

## 1.3.0-0 (2021-03-01)

### Dependencies

- androidx.fragment 1.2.5 -> 1.3.0

## 1.2.5-0

First release


[1.3.6-1]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/ec4d0fb8...fragment-args-ktx-v1.3.6-1
[1.3.6-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/fe55b501...fragment-args-ktx-v1.3.6-0
[1.3.5-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/core-ktx-v1.5.0-0...fragment-args-ktx-v1.3.5-0
