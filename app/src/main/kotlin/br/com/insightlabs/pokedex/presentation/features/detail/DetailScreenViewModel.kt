package br.com.insightlabs.pokedex.presentation.features.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import br.com.insightlabs.pokedex.core.BaseViewModel
import br.com.insightlabs.pokedex.core.runCatching
import br.com.insightlabs.pokedex.domain.usecases.GetStatsPokemonByIdUseCase
import br.com.insightlabs.pokedex.presentation.features.detail.navigation.DetailNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getStatsPokemonByIdUseCase: GetStatsPokemonByIdUseCase
) : BaseViewModel<DetailState, DetailAction>(DetailState()) {

    private val pokemonIdArg: Int = checkNotNull(
        savedStateHandle[DetailNavigation.pokemonIdArg]
    )

    private val pokemonNameArg: String = checkNotNull(
        savedStateHandle[DetailNavigation.pokemonNameArg]
    )

    init {
        getPokemonByName()
    }

    fun getPokemonByName() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getStatsPokemonByIdUseCase(pokemonIdArg)
            },
            onSuccess = { pokemon ->
                setState {
                    pokemon.id = pokemonIdArg
                    pokemon.name = pokemonNameArg
                    copy(
                        isLoading = false,
                        pokemonStats = pokemon
                    )
                }
            }
        )
    }
}