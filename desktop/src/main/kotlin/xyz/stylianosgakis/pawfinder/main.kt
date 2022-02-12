package xyz.stylianosgakis.pawfinder

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PawFinder for Desktop",
        state = rememberWindowState(width = 420.dp, height = 900.dp)
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                val scrollState = rememberScrollState()
                Column(
                    Modifier
                        .verticalScroll(scrollState)
                        .weight(1f),
                ) {
                    repeat(400) {
                        Text(text = "${Greeting().greeting()} $it")
                    }
                }
                VerticalScrollbar(
                    rememberScrollbarAdapter(scrollState),
                    Modifier.fillMaxHeight(),
                )
            }
        }
    }
}
