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

    implementation(Kotlinx.htmlJs)
    with(React) {
        implementation(dom)
        implementation(react)
        implementation(routerDom)
        implementation(styledNext)
    }

    // Material Design Components for React
    // todo look into this to make a proper UI implementation(npm("@material-ui/core", "4.11.1"))
}
