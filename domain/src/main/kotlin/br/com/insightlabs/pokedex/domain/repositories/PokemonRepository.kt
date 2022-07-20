package br.com.insightlabs.pokedex.domain.repositories

import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.PokemonStats

interface PokemonRepository {
    suspend fun getAllPokemon(
        limit: Int,
        offset: Int
    ): Pokemon

    suspend fun getStatsPokemonById(id: Int): PokemonStats
}
