package com.redmadrobot.extensions.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Rule
import kotlin.test.Test

class LiveDataAccessorsTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private val liveData = MutableLiveData<Int>()
    private var liveDataContent by liveData

    @Test
    fun setValue() {
        // When
        liveDataContent = 42

        // Then
        assertThat(liveData.value).isEqualTo(42)
    }

    @Test
    fun getValue() {
        // Given
        liveData.value = 300

        // When
        val value = liveDataContent

        // Then
        assertThat(value).isEqualTo(300)
    }

    @Test
    fun `getValue - and value is not initialized - should throw exception`() {
        // Expect
        assertThatThrownBy { liveDataContent }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("Required value was null.")
    }
}
