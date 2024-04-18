package com.redmadrobot.eventqueue.flow

import com.redmadrobot.eventqueue.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

public class EventQueue {

    private val eventsFlow = MutableStateFlow<List<Event>>(emptyList())

    @OptIn(ExperimentalCoroutinesApi::class)
    public val flow: Flow<Event>
        get() = eventsFlow.flatMapConcat { consumeAll() }

    public fun offerEvent(event: Event) {
        eventsFlow.update { it + event }
    }

    private fun consumeAll(): Flow<Event> = eventsFlow.getAndUpdate { emptyList() }.asFlow()
}
