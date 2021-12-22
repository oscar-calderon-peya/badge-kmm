package com.workshop.badge

expect class LocalStorage(platformContext: PlatformContext) {
    fun putString(key: String, value: String)
    fun getString(key: String): String?
}