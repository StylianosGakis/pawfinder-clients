package xyz.stylianosgakis.pawfinder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.statusBarsPadding
import xyz.stylianosgakis.pawfinder.Greeting

@Composable
fun MainScreen() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            repeat(40) {
                Text(text = "${Greeting().greeting()} $it")
            }
            Spacer(Modifier.navigationBarsHeight())
        }
    }
}
