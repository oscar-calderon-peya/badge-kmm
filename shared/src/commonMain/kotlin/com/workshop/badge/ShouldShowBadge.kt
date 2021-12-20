package com.workshop.badge

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
class ShouldShowBadge(private val lastCheckedTime: LastCheckedTime, private val clock: Clock) {

    fun invoke(): Boolean {
        val timeZone = TimeZone.currentSystemDefault()
        val checkedTimeInstant = lastCheckedTime.get()?.toInstant(timeZone) ?: return true
        val currentMoment = clock.now().toInstant(timeZone)
        val dateUtilCheckedTimeIsValid = checkedTimeInstant.plus(Duration.Companion.hours(24))
        return currentMoment > dateUtilCheckedTimeIsValid
    }
}

interface LastCheckedTime {
    fun get(): LocalDateTime?
}

interface Clock {
    fun now(): LocalDateTime
}