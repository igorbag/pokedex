package br.com.insightlabs.pokedex.remote.service

import br.com.insightlabs.pokedex.remote.model.Pokemon
import br.com.insightlabs.pokedex.remote.model.PokemonStats
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon")
    suspend fun getAllPokemon(): Pokemon

    @GET("pokemon/{id}")
    suspend fun getStatsPokemonById(@Path("id") id: Int): PokemonStats
}
