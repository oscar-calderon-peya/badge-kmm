package com.workshop.badge

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias PlatformContext = NSObject

actual class LocalStorage actual constructor(platformContext: PlatformContext) {

    actual fun putString(key: String, value: String) {
        NSUserDefaults.standardUserDefaults.setObject(value,key)
    }

    actual fun getString(key: String): String? {
        return NSUserDefaults.standardUserDefaults.stringForKey(key)
    }
}