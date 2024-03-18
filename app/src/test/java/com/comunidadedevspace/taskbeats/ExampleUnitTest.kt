package com.comunidadedevspace.taskbeats

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mockNumberProvider:MyNumbersProvider = mock()

    private val undertTest = MyCountRepositoryImpl(
        numbersProvider = mockNumberProvider
    )


    @Test
    fun addition_isCorrect() {

        whenever(mockNumberProvider.getNumber()).thenReturn(2)

        val result = undertTest.sum()

        val expected = 4
        assertEquals(expected, result)
    }
}

