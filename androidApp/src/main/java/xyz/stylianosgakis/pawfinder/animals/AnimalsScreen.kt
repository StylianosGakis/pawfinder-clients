package xyz.stylianosgakis.pawfinder.animals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import xyz.stylianosgakis.pawfinder.GetAnimalsQuery
import xyz.stylianosgakis.pawfinder.Greeting
import xyz.stylianosgakis.pawfinder.animals.composable.AnimalItem

@Composable
fun AnimalsScreen(viewModel: AnimalsViewModel) {
    val viewState by viewModel.viewState.collectAsState()
    AnimalsScreen(viewState)
}

@Composable
private fun AnimalsScreen(viewState: AnimalsViewState) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        when (viewState) {
            is AnimalsViewState.Content -> AnimalListScreen(viewState.animals)
            AnimalsViewState.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("ERROR")
                }
            }
            AnimalsViewState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
private fun AnimalListScreen(animals: List<GetAnimalsQuery.Data.Animal>) {
    LazyColumn(
        contentPadding = rememberInsetsPaddingValues(LocalWindowInsets.current.systemBars)
    ) {
        item {
            Text(text = Greeting().greeting())
        }
        itemsIndexed(
            items = animals,
            key = { _, animal -> animal.id },
            contentType = { _, _ -> GetAnimalsQuery.Data.Animal::class }
        ) { index, animal ->
            AnimalItem(index, animal)
        }
    }
}
