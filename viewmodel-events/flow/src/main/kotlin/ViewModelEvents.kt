package com.redmadrobot.gears.viewmodelevents

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

/**
 * Queue implemented via flow to handle one-time events.
 *
 * It buffers events and emits them when you start to observe [ViewModelEvents].
 * Events queue can be used to show messages or errors to a user once.
 * @see Event
 */
public class ViewModelEvents {
    private val eventsFlow = MutableStateFlow<List<Event>>(emptyList())

    /** Returns a flow of events from the event queue. */
    @OptIn(ExperimentalCoroutinesApi::class)
    public val flow: Flow<Event>
        get() = eventsFlow.flatMapConcat { consumeAll() }

    /** Offers the given [event] to be added to the event queue. */
    public fun offerEvent(event: Event) {
        eventsFlow.update { it + event }
    }

    private fun consumeAll(): Flow<Event> = eventsFlow.getAndUpdate { emptyList() }.asFlow()
}
