package br.com.insightlabs.pokedex.presentation.features.chooseyou

import br.com.insightlabs.pokedex.domain.model.Result

data class ChooseYouState(
    val isLoading: Boolean = false,
    val pokemon: Result = Result(
        name = "Fake",
        url = "https://pokeapi.co/api/v2/pokemon/1/"
    )
)

