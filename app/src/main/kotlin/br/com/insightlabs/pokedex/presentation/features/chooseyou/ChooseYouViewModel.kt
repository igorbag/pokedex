package br.com.insightlabs.pokedex.presentation.features.chooseyou

import androidx.lifecycle.viewModelScope
import br.com.insightlabs.pokedex.core.BaseViewModel
import br.com.insightlabs.pokedex.core.runCatching
import br.com.insightlabs.pokedex.domain.usecases.GetRandomPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseYouViewModel @Inject constructor(
    private val getRandomPokemonUseCase: GetRandomPokemonUseCase,
) : BaseViewModel<ChooseYouState, ChooseYouAction>(ChooseYouState()) {

    init {
        getAllPokemons()
    }

    fun getAllPokemons() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getRandomPokemonUseCase()
            },
            onSuccess = { pokemon ->
                setState {
                    copy(isLoading = false, pokemon = pokemon)
                }
            }
        )
    }
}
