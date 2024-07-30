package com.redmadrobot.viewmodelevents

import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * ViewModel events queue to handle one-time events.
 *
 * It buffers events and emits them when you start to observe [ViewModelEvents].
 * Can be used to show messages or errors to a user once.
 * @see Event
 */
public class ViewModelEvents {

    private val liveData = MutableLiveData<Queue<Event>>()

    /** Returns immutable list of all events from the queue. */
    public val events: List<Event>
        get() = liveData.value?.toList().orEmpty()

    /** Adds the given [event] to the queue. */
    @MainThread
    public fun offerEvent(event: Event) {
        val queue = liveData.value ?: LinkedList()
        queue.add(event)
        liveData.value = queue
    }

    /**
     * Observes this `ViewModelEvents` within the given [lifecycleOwner] lifespan.
     * Events will be consumed by the specified function [onEvent].
     * @see LiveData.observe
     */
    public fun observe(lifecycleOwner: LifecycleOwner, onEvent: (Event) -> Unit) {
        liveData.observe(lifecycleOwner) { consumeEvents(it, onEvent) }
    }

    /**
     * Observes this `ViewModelEvents`.
     * Events will be consumed by the specified function [onEvent].
     * @see LiveData.observeForever
     */
    public fun observeForever(onEvent: (Event) -> Unit) {
        liveData.observeForever { consumeEvents(it, onEvent) }
    }

    private inline fun consumeEvents(events: Queue<Event>, consumeEvent: (Event) -> Unit) {
        while (events.isNotEmpty()) consumeEvent(events.remove())
    }
}

/**
 * Shorter way to observe [LiveData] changes in a fragment using view lifecycle owner.
 * @see LiveData.observe
 */
public fun Fragment.observe(viewModelEvents: ViewModelEvents, onEvent: (Event) -> Unit) {
    viewModelEvents.observe(viewLifecycleOwner, onEvent)
}

/**
 * Shorter way to observe [LiveData] changes in an activity.
 * @see LiveData.observe
 */
public fun ComponentActivity.observe(viewModelEvents: ViewModelEvents, onEvent: (Event) -> Unit) {
    viewModelEvents.observe(this, onEvent)
}
