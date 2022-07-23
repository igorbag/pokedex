package br.com.insightlabs.pokedex.presentation.features.list

import br.com.insightlabs.pokedex.domain.model.Result


data class ListState(
    val isLoading: Boolean = false,
    val pokemons: List<Result> = emptyList()
)
