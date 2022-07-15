package br.com.insightlabs.pokedex.presentation.detail

import br.com.insightlabs.pokedex.domain.model.PokemonStats

data class DetailState(
    val isLoading: Boolean = false,
    val pokemonStats: PokemonStats = PokemonStats(
        id = 0,
        name = "",
        stats = emptyList()
    )
)

