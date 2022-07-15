package br.com.insightlabs.pokedex.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import br.com.insightlabs.pokedex.core.BaseViewModel
import br.com.insightlabs.pokedex.core.runCatching
import br.com.insightlabs.pokedex.domain.usecases.GetAllPokemonsUseCase
import br.com.insightlabs.pokedex.presentation.list.navigation.ListNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
) : BaseViewModel<ListState, ListAction>(ListState()) {

    init {
        getAllPokemons()
    }

    fun getAllPokemons() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getAllPokemonsUseCase()
            },
            onSuccess = { pokemon ->
                setState {
                    copy(isLoading = false, pokemons = pokemon)
                }
            }
        )
    }

}