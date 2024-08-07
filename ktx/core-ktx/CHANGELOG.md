## Unreleased

### Changes

- `minSdk` version changed 19 → 21
- **SharedPreferences**: Removed nullable accessors with default parameter
- **Context**: Added `Context.findActivity()` and `Context.findWindow()` extensions

## [1.6.0-2] (2021-11-16)

### Fixed

- **SharedPreferences delegates**: added ability to use delegate in local and top-level properties

## [1.6.0-1] (2021-10-03)

### Added

- **Canvas**: new extensions `withClipOut`

### Changed

- **Potentially breaking change!**
  Removed `default` parameter from `*Nullable` delegates, it will always return null by default.

### Fixed

- Added `inline` modifier to Keyboard extensions
- Default value in `SharedPreferences` delegate should not be evaluated before it needed (similar to #31)

### Dependencies

- kotlin-stdlib 1.5.20 -> 1.5.31

## [1.6.0-0] (2021-07-05)

### Dependencies

- androidx.core 1.5.0 -> 1.6.0

## [1.5.0-0] (2021-06-26)

### Dependencies

- kotlin-stdlib-jdk8 1.4.32 -> kotlin-stdlib 1.5.20
- androidx.core 1.3.2 -> 1.5.0

### Added

- `View.isKeyboardVisible: Boolean` and `Activity.isKeyboardVisible: Boolean`
- `View.showKeyboard()`
- `View.hideKeyboard()` and `Activity.hideKeyboard()`

## 1.3.2-0 (2020-10-26)

First release


[1.6.0-2]: https://github.com/RedMadRobot/gears-android/compare/core-ktx-v1.6.0-1...ec4d0fb8
[1.6.0-1]: https://github.com/RedMadRobot/gears-android/compare/resources-ktx-v1.3.1-0...core-ktx-v1.6.0-1
[1.6.0-0]: https://github.com/RedMadRobot/gears-android/compare/viewbinding-ktx-v4.2.1-0...core-ktx-v1.6.0-0
[1.5.0-0]: https://github.com/RedMadRobot/gears-android/compare/e6b11af4...core-ktx-v1.5.0-0
