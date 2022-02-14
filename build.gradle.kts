buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath("com.android.tools.build:gradle:${Versions.gradlePlugin}")
        classpath("com.apollographql.apollo3:apollo-gradle-plugin:${Versions.apolloGraphql}")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Versions.buildKonfig}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.13.0"
}
