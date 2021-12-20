package com.workshop.badge

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
class ShouldShowBadge(private val lastCheckedTimeRepository: LastCheckedTimeRepository, private val clock: Clock) {

    fun invoke(): Boolean {
        val timeZone = TimeZone.currentSystemDefault()
        val checkedTimeInstant = lastCheckedTimeRepository.get()?.toInstant(timeZone) ?: return true
        val currentMoment = clock.now().toInstant(timeZone)
        val dateUtilCheckedTimeIsValid = checkedTimeInstant.plus(Duration.Companion.hours(24))
        return currentMoment > dateUtilCheckedTimeIsValid
    }
}

interface LastCheckedTimeRepository {
    fun get(): LocalDateTime?
    fun set(time: LocalDateTime)
}

interface Clock {
    fun now(): LocalDateTime
}