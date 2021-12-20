package com.workshop.badge

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}