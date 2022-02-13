pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "PawFinderKmp"
include(":shared")
include(":androidApp")
include(":desktop")
include(":web")
