object Versions {
    const val kotlinVersion = "1.6.10"
    const val kotlinCoroutines = "1.6.0"

    const val accompanist = "0.24.2-alpha"
    const val compose = "1.2.0-alpha03"
    const val composeCompiler = "1.2.0-alpha03"
    const val composeDesktopWeb = "1.0.1"

    const val kotlinReact = "17.0.2-pre.298-kotlin-1.6.10"
    const val kotlinReactCss = "17.0.2-pre.288-kotlin-1.6.10"
    const val kotlinReactDom = "17.0.2-pre.298-kotlin-1.6.10"
    const val kotlinReactRouter = "6.2.1-pre.298-kotlin-1.6.10"
    const val kotlinxHtmlJs = "0.7.3"

    const val kmpNativeCoroutines = "0.11.1-new-mm"

    const val navCompose = "2.4.1"

    const val junit = "4.13.2"
}

object AndroidSdk {
    const val min = 24
    const val compile = 31
    const val target = 30
}

object Android {
    const val material = "com.google.android.material:material:1.5.0"
}

object Compose {
    const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"

    const val activityCompose = "androidx.activity:activity-compose:1.4.0"
}

object Google {
    object Accompanist {
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    }
}

object Kotlinx {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"

    const val htmlJs = "org.jetbrains.kotlinx:kotlinx-html-js:${Versions.kotlinxHtmlJs}"
}

object React {
    const val react = "org.jetbrains.kotlin-wrappers:kotlin-react:${Versions.kotlinReact}"
    const val reactCss = "org.jetbrains.kotlin-wrappers:kotlin-react-css:${Versions.kotlinReactCss}"
    const val reactDom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom:${Versions.kotlinReactDom}"
    const val reactRouter = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:${Versions.kotlinReactRouter}"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val composeUiTest = "androidx.compose.ui:ui-test:${Versions.compose}"
    const val composeUiTestJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
}

object Touchlab {
    const val kermit = "co.touchlab:kermit:1.0.3"
}
