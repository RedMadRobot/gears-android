## Unreleased

- **EventQueue** - moved to separate package eventqueue-livedata

### Dependencies

- androidx.activity 1.2.3 -> 1.3.1
- androidx.fragment 1.3.5 -> 1.3.6
- kotlin-stdlib 1.5.20 -> 1.5.31

## [2.3.1-0] (2021-06-26)

### Dependencies

- kotlin-stdlib-jdk8 1.4.32 -> kotlin-stdlib 1.5.20
- androidx.lifecycle 2.3.0 -> 2.3.1
- androidx.activity 1.2.0 -> 1.2.3
- androidx.annotation 1.1.0 -> 1.2.0
- androidx.fragment 1.3.0 -> 1.3.5

### Added

- Field `EventQueue.events: List<Event>` to get events stored in the queue.

## 2.3.0-0 (2021-03-01)

### Dependencies

- androidx.lifecycle 2.2.0 -> 2.3.0
- androidx.activity 1.1.0 -> 1.2.0
- androidx.fragment 1.2.5 -> 1.3.0

### Changes

- Replace `LiveData.getValue` and `MutableLiveData.setValue` operators with `provideDelegate` operator (#8).
  `getValue` and `setValue` are deprecated now and will be removed in future versions.

## 2.2.0-0

First release


[2.3.1-0]: https://github.com/RedMadRobot/redmadrobot-android-ktx/compare/fragment-ktx-v1.3.5-0...lifecycle-livedata-ktx-v2.3.1-0
