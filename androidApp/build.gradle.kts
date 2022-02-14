plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AndroidSdk.compile

    defaultConfig {
        applicationId = "xyz.stylianosgakis.pawfinder"
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "META-INF/LGPL2.1"
            excludes += "META-INF/AL2.0"
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Android.material)
    with(Compose) {
        implementation(activityCompose)
        implementation(compiler)
        implementation(ui)
        implementation(uiGraphics)
        debugImplementation(uiTooling)
        implementation(uiToolingPreview)
        implementation(foundation)
        implementation(material)
        implementation(navigation)
    }
    with(Google.Accompanist) {
        implementation(insets)
        implementation(systemUiController)
    }
    with(Koin) {
        implementation(android)
    }
    with(Test) {
        testImplementation(junit)
        testImplementation(composeUiTest)
        testImplementation(composeUiTestJUnit)
        testImplementation(composeUiTestManifest)
    }
}
