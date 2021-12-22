package com.workshop.badge

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

actual typealias PlatformContext = Activity

actual class LocalStorage actual constructor(platformContext: PlatformContext) {

    private var preferences: SharedPreferences =
        platformContext.getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)

    companion object {
        const val SHARED_PREFERENCES_KEY = "badge-storage"
    }

    actual fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    actual fun getString(key: String): String? {
        return preferences.getString(key, null)
    }
}

