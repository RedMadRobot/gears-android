package com.redmadrobot.extensions.lifecycle

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * Queue to handle one-time events.
 *
 * It buffers events and emits them when you start to observe [EventQueue].
 * Events queue can be used to show messages or errors to a user once.
 * @see Event
 */
public class EventQueue {

    private val liveData = MutableLiveData<Queue<Event>>()

    /** Adds given [event] to the queue. */
    @MainThread
    public fun offerEvent(event: Event) {
        val queue = liveData.value ?: LinkedList()
        queue.add(event)
        liveData.value = queue
    }

    /**
     * Observes this `EventQueue` within given [lifecycleOwner] lifespan.
     * Events will be consumed by specified function [onEvent].
     * @see LiveData.observe
     */
    public fun observe(lifecycleOwner: LifecycleOwner, onEvent: (Event) -> Unit) {
        liveData.observe(lifecycleOwner) { consumeEvents(it, onEvent) }
    }

    /**
     * Observes this `EventQueue`.
     * Events will be consumed by specified function [onEvent].
     * @see LiveData.observeForever
     */
    public fun observeForever(onEvent: (Event) -> Unit) {
        liveData.observeForever { consumeEvents(it, onEvent) }
    }

    private inline fun consumeEvents(events: Queue<Event>, consumeEvent: (Event) -> Unit) {
        while (events.isNotEmpty()) consumeEvent(events.remove())
    }
}

/** Marker interface for entities that can be put to the [EventQueue]. */
public interface Event

/**
 * Shorter way to observe [LiveData] changes in a fragment using view lifecycle owner.
 * @see LiveData.observe
 */
@Suppress("NOTHING_TO_INLINE")
public inline fun Fragment.observe(eventQueue: EventQueue, noinline onEvent: (Event) -> Unit) {
    eventQueue.observe(viewLifecycleOwner, onEvent)
}

/**
 * Shorter way to observe [LiveData] changes in an activity.
 * @see LiveData.observe
 */
@Suppress("NOTHING_TO_INLINE")
public inline fun ComponentActivity.observe(eventQueue: EventQueue, noinline onEvent: (Event) -> Unit) {
    eventQueue.observe(this, onEvent)
}
