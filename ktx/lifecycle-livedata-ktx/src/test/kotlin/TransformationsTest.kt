package com.redmadrobot.extensions.lifecycle

import androidx.lifecycle.MutableLiveData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExtendWith(InstantExecutorExtension::class)
internal class TransformationsTest {

    private val liveData = MutableLiveData(42)

    private val isOdd by lazy { liveData.mapDistinct { it % 2 != 0 } }
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
