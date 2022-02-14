package xyz.stylianosgakis.pawfinder.animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import xyz.stylianosgakis.pawfinder.GetAnimalsQuery
import xyz.stylianosgakis.pawfinder.backend.GetAnimalsUseCase
import xyz.stylianosgakis.pawfinder.type.AnimalType
import xyz.stylianosgakis.pawfinder.type.LimitInput

class AnimalsViewModel(
    getAnimalsUseCase: GetAnimalsUseCase,
) : ViewModel() {
    val viewState: StateFlow<AnimalsViewState> = flow {
        getAnimalsUseCase
            .invoke(AnimalType.CAT, LimitInput(50), 1)
            .fold(
                { AnimalsViewState.Error },
                { AnimalsViewState.Content(it.animals) }
            )
            .let { emit(it) }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        initialValue = AnimalsViewState.Loading
    )
}

sealed interface AnimalsViewState {
    object Loading : AnimalsViewState
    object Error : AnimalsViewState
    data class Content(val animals: List<GetAnimalsQuery.Data.Animal>) : AnimalsViewState
}
