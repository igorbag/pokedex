package br.com.insightlabs.pokedex.presentation.features.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import br.com.insightlabs.pokedex.core.BaseViewModel
import br.com.insightlabs.pokedex.core.runCatching
import br.com.insightlabs.pokedex.domain.model.Result
import br.com.insightlabs.pokedex.domain.usecases.GetAllPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase,
) : BaseViewModel<ListState, ListAction>(ListState()) {

    private var curPage = PAGE_INITIAL
    var pokemonList = mutableStateOf<List<Result>>(listOf())

    init {
        getAllPokemons()
    }

    fun getAllPokemons() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getAllPokemonsUseCase(
                    limit = PAGE_SIZE,
                    offset = PAGE_SIZE * curPage
                )
            },
            onSuccess = { pokemon ->
                curPage++
                pokemonList.value += pokemon.results
                setState {
                    copy(isLoading = false, pokemons = pokemonList.value)
                }
            }
        )
    }

    companion object {
        const val PAGE_SIZE = 20
        const val PAGE_INITIAL = 0
    }
}
