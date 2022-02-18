package xyz.stylianosgakis.pawfinder

import java.util.UUID

actual fun randomUUID(): String {
    return UUID.randomUUID().toString()
}
