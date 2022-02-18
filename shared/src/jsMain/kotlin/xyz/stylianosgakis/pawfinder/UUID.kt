package xyz.stylianosgakis.pawfinder

import com.benasher44.uuid.uuid4

actual fun randomUUID(): String {
    return uuid4().toString()
}
