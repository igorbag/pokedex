package br.com.insightlabs.pokedex.repositories

import br.com.insightlabs.pokedex.model.Pokemon

interface PokemonRepository {
    suspend fun getAllPokemon(): List<Pokemon>
    suspend fun getPokemonByName(name: String): Pokemon
}