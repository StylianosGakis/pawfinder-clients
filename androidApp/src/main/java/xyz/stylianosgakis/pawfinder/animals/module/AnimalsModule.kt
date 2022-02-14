@file:Suppress("RemoveExplicitTypeArguments")

package xyz.stylianosgakis.pawfinder.animals.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import xyz.stylianosgakis.pawfinder.animals.AnimalsViewModel

val animalsModule: Module = module {
    viewModel<AnimalsViewModel> { AnimalsViewModel(get()) }
}
