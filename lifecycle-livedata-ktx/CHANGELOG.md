## Unreleased

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
