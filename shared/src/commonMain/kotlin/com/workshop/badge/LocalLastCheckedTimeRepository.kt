package com.workshop.badge

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

class LocalLastCheckedTimeRepository(private val localStorage: LocalStorage): LastCheckedTimeRepository {

    override fun get(): LocalDateTime? {
        return localStorage.getString(checkedTimeKey)?.toLocalDateTime()
    }

    override fun set(time: LocalDateTime) {
        localStorage.putString(checkedTimeKey, time.toString())
    }

    companion object {
        const val checkedTimeKey = "checked-time"
    }
}