## Unreleased

- *No changes*

## 0.2.0 (2026-07-10)

### Breaking changes

- `resultFlow(block: suspend () -> Result<T>)` is no longer available from source code.
  In 0.1.0 the two `resultFlow` overloads had ambiguous resolution: a block returning `Result<T>` could end up single- or double-wrapped depending on how it was typed.

  The overload is now hidden (`DeprecationLevel.HIDDEN` + `@JvmSynthetic`), so `resultFlow(block: suspend () -> T)` is the only source-visible overload; exceptions thrown from `block` are caught and wrapped into `Result.failure`.

  Because the `Result<T>` overload is hidden, a block that already returns `Result<T>` now binds to the raw-value overload and produces a double-wrapped `Flow<Result<Result<T>>>` — there is **no** compile-time error, so migrate such call sites explicitly:
  ```kotlin
  // Before (0.1.0) — emitted the Result as-is:
  resultFlow { repository.fetchData() }  // fetchData(): Result<Data>

  // After — unwrap the Result inside the block (failure is caught and re-wrapped):
  resultFlow { repository.fetchData().getOrThrow() }

  // Or build the flow manually to emit the Result as-is (without catching):
  flow { emit(repository.fetchData()) }
  ```
- The overload is now `@JvmSynthetic`, so it is also hidden from Java source. Its `@JvmName("resultFlowResult")` is retained, so code already compiled against 0.1.0 keeps linking against it and behaves as before — the break is source-level only.

## [0.1.0] (2024-08-01)

Initial release


[0.1.0]: https://github.com/RedMadRobot/gears-android/compare/9ada4423...resultflow-v0.1.0
