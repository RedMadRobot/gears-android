package com.redmadrobot.gears.resultflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Creates a flow containing a single value – the result of the given [block] wrapped into [Result].
 * Any exception thrown from [block] is caught and emitted as [Result.failure].
 *
 * If [block] itself returns `Result<T>`, wrapping it again would produce a double-wrapped
 * `Flow<Result<Result<T>>>`. Unwrap the [Result] inside the block (e.g. `block().getOrThrow()`)
 * so its failure is caught as above, or build the flow manually via [flow] to emit a pre-built
 * [Result] as-is.
 *
 * @see flow
 * @see toResultFlow
 */
public inline fun <T> resultFlow(crossinline block: suspend () -> T): Flow<Result<T>> {
    return flow { emit(block()) }
        .toResultFlow()
}

/**
 * Bytecode-only overload for a [block] that already returns `Result<T>`: it emits the pre-built
 * [Result] as-is, yielding `Flow<Result<T>>` (single-wrapped, with the failure left un-caught)
 * instead of the double-wrapped `Flow<Result<Result<T>>>` the raw-value overload would produce.
 *
 * It is hidden from Kotlin sources via [DeprecationLevel.HIDDEN] and from Java via [JvmSynthetic],
 * so it is not a candidate for new callers; it stays in the bytecode only to keep already-compiled
 * code working. New code should unwrap the [Result] inside the block or use `flow { emit(block()) }`.
 */
@Deprecated(
    "Block returning Result<T> would produce Flow<Result<Result<T>>>. " +
        "Unwrap the Result inside the block (e.g., block().getOrThrow()), " +
        "or use `flow { emit(block()) }` to emit the Result as-is.",
    level = DeprecationLevel.HIDDEN,
)
@JvmName("resultFlowResult")
@JvmSynthetic
public fun <T> resultFlow(block: suspend () -> Result<T>): Flow<Result<T>> {
    return flow { emit(block()) }
}

/** Wraps values and errors from [this] flow with [Result]. */
public fun <T> Flow<T>.toResultFlow(): Flow<Result<T>> {
    return map { Result.success(it) }
        .catch { emit(Result.failure(it)) }
}

@Deprecated(
    "Call toResultFlow() on Flow<Result<T>> is redundant and can be removed.",
    ReplaceWith("this"),
    level = DeprecationLevel.ERROR,
)
@JvmName("-redundant_toResultFlow")
public fun <T> Flow<Result<T>>.toResultFlow(): Flow<Result<T>> = this

/**
 * Calls the [Result.fold] on a flow containing [Result].
 * Shorthand for `map { it.fold(...) }`
 */
public inline fun <T, R : Any> Flow<Result<T>>.foldEach(
    crossinline onSuccess: (T) -> R,
    crossinline onFailure: (Throwable) -> R,
): Flow<R> {
    return map { it.fold(onSuccess, onFailure) }
}
