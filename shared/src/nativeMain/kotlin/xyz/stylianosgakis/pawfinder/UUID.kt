package xyz.stylianosgakis.pawfinder

import platform.Foundation.NSUUID

actual fun randomUUID(): String {
    return NSUUID.UUID().UUIDString
}
