package com.redmadrobot.extensions.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import kotlin.test.BeforeTest
import kotlin.test.Test

class TransformationsTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private val liveData = MutableLiveData(42)

    private val isOdd = liveData.mapDistinct { it % 2 != 0 }
    private val values = mutableListOf<Boolean>()

    @BeforeTest
    fun setUp() {
        isOdd.observeForever { values.add(it) }
    }

    @Test
    fun `mapDistinct - when parity not changed - should not emmit new value`() {
        // When
        liveData.value = 2

        // Then
        assertThat(values).containsExactly(false)
    }

    @Test
    fun `mapDistinct - when parity changed - should new value`() {
        // When
        liveData.value = 1

        // Then
        assertThat(values).containsExactly(false, true)
    }
}
