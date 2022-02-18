package xyz.stylianosgakis.pawfinder

import kotlin.js.JsExport

expect val platform: String

@JsExport
class Greeting {
    fun greeting() = "Hello, $platform! User uuid number:${randomUUID()}"
}
