package xyz.stylianosgakis.pawfinder.animals.composable

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import xyz.stylianosgakis.pawfinder.GetAnimalsQuery

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimalItem(index: Int, animal: GetAnimalsQuery.Data.Animal) {
    ListItem(
        modifier = Modifier.graphicsLayer(rotationY = if (index.isEven) 0f else 180f),
        text = { Text(animal.name) },
        secondaryText = animal.description?.let { { Text(it) } },
    )
}

private val Int.isEven: Boolean
    get() = this % 2 == 0
