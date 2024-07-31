package com.redmadrobot.gears.resultflow

import com.redmadrobot.gears.resultflow.ResultState.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

/**
 * Represents three possible states during a result pending.
 *
 * - [Pending] – A result that is still pending and has not yet completed.
 * - [Success] – A successful result.
 * - [Failure] – A failed result, contains the exception that caused the failure.
 *
 * @see onEachState
 */
public sealed interface ResultState {

    /** Shorthand for `status is ResultState.Pending`. */
    public val isPending: Boolean
        get() = this is Pending

    /** Shorthand for `status is ResultState.Success`. */
    public val isSuccess: Boolean
        get() = this is Success

    /** Shorthand for `status is ResultState.Failure`. */
    public val isFailure: Boolean
        get() = this is Failure

    /** Returns an exception */
    public fun exceptionOrNull(): Throwable? = if (this is Failure) exception else null

    /** Represents a result that is still pending and has not yet completed. */
    public data object Pending : ResultState

    /** Represents a successful result. */
    public data object Success : ResultState

    /** Represents a failed result. Contains the [exception] that caused the failure */
    public data class Failure(val exception: Throwable) : ResultState

    /** Extension point to give an ability to create extension-functions on a companion object. */
    public companion object
}

/**
 * Returns the flow that invokes the given [action] on each [ResultState] of this flow.
 * It always calls the [action] passing the [ResultState.Pending] first.
 */
public fun <T> Flow<Result<T>>.onEachState(action: suspend (ResultState) -> Unit): Flow<Result<T>> {
    return onStart { action(Pending) }
        .onEach { result ->
            val state = result.fold(
                onSuccess = { Success },
                onFailure = { Failure(it) },
            )
            action(state)
        }
}
