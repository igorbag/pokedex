package br.com.insightlabs.pokedex.presentation.list

import br.com.insightlabs.pokedex.domain.model.Pokemon


data class ListState(
    val isLoading: Boolean = false,
    val pokemons: Pokemon = Pokemon(results = emptyList())
)
