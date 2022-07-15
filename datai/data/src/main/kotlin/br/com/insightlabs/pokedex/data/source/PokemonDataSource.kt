package br.com.insightlabs.pokedex.data.source

import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.PokemonStats

sealed interface PokemonDataSource {
    interface Remote : PokemonDataSource {
        suspend fun getAllPokemon(): Pokemon
        suspend fun getStatsPokemonById(id: Int): PokemonStats
    }
}
