## Unreleased

### Changed

- **Text**: added abstract methods `equals`, `hashCode`
- **Text**: added `Parcelable` implementation
- **Text**: added `Companion object` and `Text.EMPTY` implementation

## [1.3.1-0] (2021-10-03)

### Added

- **Context**: added type checks to extensions `resolveColor`
- **Context**: new extensions `resolveDimension`, `resolveDimensionPixelSize` and `resolveDimensionPixelOffset`
- **Context**: new extensions `resolveBoolean`, `resolveInt`, `resolveFloat` and `resolveString`
- **Fragment**: new extensions `getQuantityString`
- **View**: new extensions `getQuantityString`

### Fixed

- `Inline` modifier added back to all resource accessors

### Dependencies

- androidx.appcompat 1.3.0 -> 1.3.1
- androidx.core 1.5.0 -> 1.6.0
- androidx.fragment 1.3.5 -> 1.3.6
- kotlin-stdlib 1.5.20 -> 1.5.31

## [1.3.0-0] (2021-06-27)

### Dependencies

- kotlin-stdlib-jdk8 1.4.32 -> kotlin-stdlib 1.5.20
- androidx.appcompat 1.2.0 -> 1.3.0
- androidx.annotation 1.1.0 -> 1.2.0
- androidx.core 1.3.0 -> 1.5.0
- androidx.fragment 1.3.0 -> 1.3.5

### Added

- Wrapper `Text` to make it possible to work with plain `String` and `StringRes` in the same way.

## 1.2.0-1

### Added

- **View**, **Fragment**: new extensions `getDimensionPixelSize` and `getDimensionPixelOffset`
- **Context**: new extensions `resolveAttributeOrThrow` and `resolveAttribute`
- **Context**: new extensions `resolveColor`
- **Context**: new extension `resolveResourceId`

## 1.2.0-0

First release


[1.3.1-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/fragment-ktx-v1.3.6-0...resources-ktx-v1.3.1-0
[1.3.0-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/lifecycle-livedata-ktx-v2.3.1-0...resources-ktx-v1.3.0-0
