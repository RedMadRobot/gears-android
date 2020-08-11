package com.redmadrobot.extensions.lifecycle

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import java.util.*

/**
 * Queue to handle one-time events.
 *
 * It buffers events and emits them when you start to observe [EventQueue].
 * Events queue can be used to show messages or errors to a user once.
 * @see Event
 */
class EventQueue {

    private val liveData = MutableLiveData<Queue<Event>>()

    /** Adds given [event] to the queue. */
    @MainThread
    fun offerEvent(event: Event) {
        val queue = liveData.value ?: LinkedList()
        queue.add(event)
        liveData.value = queue
    }

    /**
     * Observes this `EventQueue` within given [lifecycleOwner] lifespan.
     * Events will be consumed by specified function [onEvent].
     * @see LiveData.observe
     */
    fun observe(lifecycleOwner: LifecycleOwner, onEvent: (Event) -> Unit) {
        liveData.observe(lifecycleOwner) { consumeEvents(it, onEvent) }
    }

    /**
     * Observes this `EventQueue`.
     * Events will be consumed by specified function [onEvent].
     * @see LiveData.observeForever
     */
    fun observeForever(onEvent: (Event) -> Unit) {
        liveData.observeForever { consumeEvents(it, onEvent) }
    }

    private inline fun consumeEvents(events: Queue<Event>, consumeEvent: (Event) -> Unit) {
        while (events.isNotEmpty()) consumeEvent(events.remove())
    }
}

/** Marker interface for entities that can be put to the [EventQueue]. */
interface Event

/**
 * Shorter way to observe [LiveData] changes in a fragment using view lifecycle owner.
 * @see LiveData.observe
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Fragment.observe(eventQueue: EventQueue, noinline onEvent: (Event) -> Unit) {
    eventQueue.observe(viewLifecycleOwner, onEvent)
}

/**
 * Shorter way to observe [LiveData] changes in an activity.
 * @see LiveData.observe
 */
@Suppress("NOTHING_TO_INLINE")
inline fun ComponentActivity.observe(eventQueue: EventQueue, noinline onEvent: (Event) -> Unit) {
    eventQueue.observe(this, onEvent)
}
