package com.workshop.badge

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.datetime.toLocalDateTime
import org.junit.Test

class UpdateCheckedTimeTest {

    private val lastCheckedTime = mock<LastCheckedTimeRepository> { }
    private val clock = mock<Clock> {  }
    private val updateCheckedTime = UpdateCheckedTime(lastCheckedTime, clock)


    @Test
    fun `update last checked time`() {
        val timeString = "2021-11-30T11:00:00"
        givenCurrentTime(timeString)

        updateCheckedTime.invoke()

        verify(lastCheckedTime).set(timeString.toLocalDateTime())
    }

    private fun givenCurrentTime(timeString: String) {
        whenever(clock.now()).thenReturn(timeString.toLocalDateTime())
    }
}