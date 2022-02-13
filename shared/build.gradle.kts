@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    jvm()
    val iosX64 = iosX64()
    val iosArm64 = iosArm64()
    val iosSimulatorArm64 = iosSimulatorArm64()
    js(IR) {
        browser()
        nodejs()
    }

    // Configure all compilations of all targets:
    targets.all {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }

    sourceSets {
        // region Common
        val commonMain by getting {
            dependencies {
                implementation(Kotlinx.coroutinesCore)
                implementation(Touchlab.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Kotlinx.coroutinesTest)
                implementation(kotlin("test"))
            }
        }
        // endregion

        // region Android
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:2.0.0-beta-1")
            }
        }
        val androidTest by getting {
            dependsOn(commonTest)
        }
        // endregion

        // region Jvm
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val jvmTest by getting {
            dependsOn(commonTest)
        }
        // endregion

        // region Js
        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
        }
        // endregion

        // region Native
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }

        val iosMain by creating {
            dependsOn(nativeMain)
        }
        val iosTest by creating {
            dependsOn(nativeTest)
        }

        listOf(
            iosArm64, iosX64, iosSimulatorArm64
        ).forEach { target: KotlinNativeTarget ->
            target.binaries.framework {
                baseName = "shared"
            }
            getByName("${target.targetName}Main") {
                dependsOn(iosMain)
            }
            getByName("${target.targetName}Test") {
                dependsOn(iosTest)
            }
        }
        // endregion
    }
}

android {
    compileSdk = AndroidSdk.compile
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
    }
}
