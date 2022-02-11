package xyz.stylianosgakis.pawfinder

expect val platform: String

class Greeting {
    fun greeting() = "Hello, $platform!"
}