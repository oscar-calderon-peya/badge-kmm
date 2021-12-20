package com.workshop.badge

class UpdateCheckedTime(
    private val lastCheckedTimeRepository: LastCheckedTimeRepository,
    private val clock: Clock
) {
    fun invoke() {
        val now = clock.now()
        lastCheckedTimeRepository.set(now)
    }

}