package com.redmadrobot.viewmodelevents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Observes events from the provided [ViewModelEvents] and triggers the specified action when new events occur.
 *
 * @param events The `ViewModelEvents` from which events will be observed
 * @param lifecycleOwner The [LifecycleOwner] to use for observing lifecycle changes (default is the current [LocalLifecycleOwner])
 * @param minActiveState The minimum active state of the `LifecycleOwner` for observing events (default is [Lifecycle.State.STARTED])
 * @param onEvent The action to perform when a new event is observed
 */
@Suppress("ComposableParametersOrdering")
@Composable
public fun ViewModelEventsEffect(
    events: ViewModelEvents,
    lifecycleOwner: LifecycleOwner? = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    onEvent: suspend (Event) -> Unit,
) {
    // Safely update the current `onEvent` lambda when a new one is provided
    val currentOnEvent by rememberUpdatedState(onEvent)

    LaunchedEffect(events, lifecycleOwner, minActiveState) {
        val eventsFlow = if (lifecycleOwner != null) {
            events.flow.flowWithLifecycle(lifecycleOwner.lifecycle, minActiveState)
        } else {
            events.flow
        }

        eventsFlow
            .onEach { currentOnEvent(it) }
            .launchIn(this)
    }
}
