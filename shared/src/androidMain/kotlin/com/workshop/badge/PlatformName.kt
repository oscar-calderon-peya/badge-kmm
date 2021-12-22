package com.workshop.badge

actual class PlatformName actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}