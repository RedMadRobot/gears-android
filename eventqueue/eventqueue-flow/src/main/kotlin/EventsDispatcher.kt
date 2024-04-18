package com.redmadrobot.eventqueue.flow

import com.redmadrobot.eventqueue.Event

public interface EventsDispatcher {

    public val events: EventQueue

    public fun offerEvent(event: Event) {
        events.offerEvent(event)
    }
}
