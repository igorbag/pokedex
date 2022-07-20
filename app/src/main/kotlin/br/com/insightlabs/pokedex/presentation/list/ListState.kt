package br.com.insightlabs.pokedex.presentation.list

import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.Result


data class ListState(
    val isLoading: Boolean = false,
    val pokemons: List<Result> = emptyList()
)
