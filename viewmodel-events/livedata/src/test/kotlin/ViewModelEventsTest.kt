package com.redmadrobot.extensions.viewmodel

import com.redmadrobot.gears.viewmodelevents.Event
import com.redmadrobot.gears.viewmodelevents.ViewModelEvents
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.Test

@ExtendWith(InstantExecutorExtension::class)
internal class ViewModelEventsTest {

    // SUT
    private val viewModelEvents = ViewModelEvents()

    @Test
    fun `subscribe - when queue is empty - should not emit any values`() {
        // Given
        val events = mutableListOf<Event>()

        // When
        viewModelEvents.observeForever { events.add(it) }

        // Then
        assertThat(events).isEmpty()
    }

    @Test
    fun `subscribe - when queue has values - should emit all values`() {
        // Given
        val events = mutableListOf<Event>()

        // When
        viewModelEvents.offerEvent(TestEvent(0))
        viewModelEvents.offerEvent(TestEvent(1))
        viewModelEvents.observeForever { events.add(it) }
        viewModelEvents.offerEvent(TestEvent(2))

        // Then
        assertThat(events).containsExactly(TestEvent(0), TestEvent(1), TestEvent(2))
    }

    @Test
    fun `subscribe - when offered events - should return list of all events`() {
        // When
        viewModelEvents.offerEvent(TestEvent(0))
        viewModelEvents.offerEvent(TestEvent(1))
        viewModelEvents.offerEvent(TestEvent(2))

        // Then
        assertThat(viewModelEvents.events).containsExactly(TestEvent(0), TestEvent(1), TestEvent(2))
    }

    private data class TestEvent(val id: Int) : Event
}
