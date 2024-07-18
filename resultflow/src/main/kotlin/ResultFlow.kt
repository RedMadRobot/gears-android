package com.redmadrobot.gears.resultflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Creates a flow containing a single value – the result returned from the given [block].
 * @see flow
 */
@JvmName("resultFlowResult")
public fun <T> resultFlow(block: suspend () -> Result<T>): Flow<Result<T>> {
    return flow { emit(block()) }
}

/**
 * Creates a flow containing a single value – the result of the given [block] wrapped into [Result].
 * @see flow
 */
public fun <T> resultFlow(block: suspend () -> T): Flow<Result<T>> {
    return flow { emit(block()) }
        .toResultFlow()
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
