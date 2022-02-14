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
import org.koin.androidx.viewmodel.ext.android.getViewModel
import xyz.stylianosgakis.pawfinder.animals.AnimalsViewModel
import xyz.stylianosgakis.pawfinder.animals.MainScreen
import xyz.stylianosgakis.pawfinder.compose.theme.PawFinderKmpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // temp until scoping VM to nav back stack
        val viewModel = getViewModel<AnimalsViewModel>()

        setContent {
            PawFinderKmpTheme {
                ColorSystemBarsContent {
                    EdgeToEdgeContent {
                        MainScreen(viewModel)
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
