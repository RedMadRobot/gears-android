package com.redmadrobot.extensions.viewmodel

import com.redmadrobot.eventqueue.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

/**
 * Queue implemented via flow to handle one-time events.
 *
 * It buffers events and emits them when you start to observe [EventQueue].
 * Events queue can be used to show messages or errors to a user once.
 * @see Event
 */
public class EventQueue {
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
