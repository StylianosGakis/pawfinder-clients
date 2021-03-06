@file:Suppress("UNUSED_VARIABLE")

import com.apollographql.apollo3.gradle.internal.ApolloDownloadSchemaTask
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.apollographql.apollo3")
    id("com.codingfeline.buildkonfig")
    id("com.rickclephas.kmp.nativecoroutines")
    id("dev.petuska.npm.publish") version "2.1.2"
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
        binaries.library()
    }

    targets.all {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.js.ExperimentalJsExport")
        }
        // region Common
        val commonMain by getting {
            dependencies {
                implementation(ApolloGraphql.runtime)
                api(Arrow.core)
                implementation(Koin.core)
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

val properties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}
val backendGraphQlEndpoint: String = properties.getProperty("backendGraphQlEndpoint")

buildkonfig {
    packageName = "xyz.stylianosgakis.pawfinder"
    defaultConfigs {
        buildConfigField(STRING, "backendGraphQlEndpoint", backendGraphQlEndpoint)
    }
}

apollo {
    service("pawFinder") {
        packageName.set("xyz.stylianosgakis.pawfinder")
        codegenModels.set("responseBased")
    }
}

tasks.register("downloadSchema", ApolloDownloadSchemaTask::class.java) {
    endpoint.set(backendGraphQlEndpoint)
    schema.set("shared/src/commonMain/graphql/xyz/stylianosgakis/pawfinder/schema.graphqls")
}

npmPublishing {
    organization = "pawfinder"

    publications {
        named("js") {
            version = "0.0.1"
            packageJson {
                author { name = "pawfinderName" }
            }
        }
    }
}
