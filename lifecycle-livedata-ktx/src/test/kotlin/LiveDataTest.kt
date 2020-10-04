package com.redmadrobot.extensions.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Rule
import org.junit.Test

internal class LiveDataTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `requireValue - should return value`() {
        // Given
        val liveData = MutableLiveData(42)

        // Then
        assertThat(liveData.requireValue()).isEqualTo(42)
    }

    @Test
    fun `requireValue - should throw exception`() {
        // Given
        val liveData = MutableLiveData<Unit>()

        // Then
        assertThatThrownBy { liveData.requireValue() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("Required value was null.")
    }
}
