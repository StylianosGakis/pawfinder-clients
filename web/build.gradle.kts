plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
    google()
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(kotlin("stdlib-js"))

    with(React) {
        implementation(react)
        implementation(reactCss)
        implementation(reactDom)
        implementation(reactRouter)
    }

    // Material Design Components for React
    // todo look into this to make a proper UI implementation(npm("@material-ui/core", "4.11.1"))
}
