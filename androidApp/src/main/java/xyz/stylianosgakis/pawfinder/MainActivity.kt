package xyz.stylianosgakis.pawfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import xyz.stylianosgakis.pawfinder.compose.theme.PawFinderKmpTheme
import xyz.stylianosgakis.pawfinder.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            PawFinderKmpTheme {
                ColorSystemBarsContent {
                    EdgeToEdgeContent {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun EdgeToEdgeContent(content: @Composable () -> Unit) {
    ProvideWindowInsets(content = content)
}

@Composable
fun ColorSystemBarsContent(
    color: Color = Color.Transparent,
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = useDarkIcons
        )
    }
    content()
}
