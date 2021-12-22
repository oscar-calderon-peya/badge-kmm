package com.workshop.badge

import platform.UIKit.UIDevice

actual class PlatformName actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}