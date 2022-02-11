package xyz.stylianosgakis.pawfinder.compose

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("unused")
fun Modifier.debugBorder(
    color: Color = Color.Red,
    dp: Dp = 1.dp,
): Modifier {
    return border(dp, color)
}
