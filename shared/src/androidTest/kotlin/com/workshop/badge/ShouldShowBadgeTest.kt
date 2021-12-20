package com.workshop.badge

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.datetime.toLocalDateTime
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime

@ExperimentalTime
class ShouldShowBadgeTest {

    private val lastCheckedTime = mock<LastCheckedTime> { }
    private val clock = mock<Clock> { }
    private val shouldShowBadge = ShouldShowBadge(lastCheckedTime, clock)

    @Test
    fun `true if it is the first time`() {
        givenCurrentTime("2021-11-30T11:00:00")
        val actual = shouldShowBadge.invoke()
        assertTrue(actual)
    }

    @Test
    fun `false when last checked time is still valid`() {
        givenCurrentTime("2021-11-30T11:00:00")
        givenLastCheckedTime("2021-11-30T10:00:00")
        val actual = shouldShowBadge.invoke()
        assertFalse(actual)
    }

    @Test
    fun `true when last checked time is over`() {
        givenCurrentTime("2021-11-30T11:00:00")
        givenLastCheckedTime("2021-11-29T10:00:00")
        val actual = shouldShowBadge.invoke()
        assertTrue(actual)
    }

    private fun givenLastCheckedTime(timeString: String?) {
        whenever(lastCheckedTime.get()).thenReturn(timeString?.toLocalDateTime())
    }

    private fun givenCurrentTime(timeString: String) {
        whenever(clock.now()).thenReturn(timeString.toLocalDateTime())
    }
}