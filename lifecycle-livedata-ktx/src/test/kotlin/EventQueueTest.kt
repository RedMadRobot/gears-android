package com.redmadrobot.extensions.lifecycle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.Test

@ExtendWith(InstantExecutorExtension::class)
internal class EventQueueTest {

    // SUT
    private val eventsQueue = EventQueue()

    @Test
    fun `subscribe - when queue is empty - should not emit any values`() {
        // Given
        val events = mutableListOf<Event>()

        // When
        eventsQueue.observeForever { events.add(it) }

        // Then
        assertThat(events).isEmpty()
    }

    @Test
    fun `subscribe - when queue has values - should emit all values`() {
        // Given
        val events = mutableListOf<Event>()

        // When
        eventsQueue.offerEvent(TestEvent(0))
        eventsQueue.offerEvent(TestEvent(1))
        eventsQueue.observeForever { events.add(it) }
        eventsQueue.offerEvent(TestEvent(2))

        // Then
        assertThat(events).containsExactly(TestEvent(0), TestEvent(1), TestEvent(2))
    }

    private data class TestEvent(val id: Int) : Event
}
