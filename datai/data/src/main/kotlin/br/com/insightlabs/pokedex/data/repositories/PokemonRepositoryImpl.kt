package br.com.insightlabs.pokedex.data.repositories

import br.com.insightlabs.pokedex.data.source.PokemonDataSource
import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.PokemonStats
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonDataSource.Remote
) : PokemonRepository {

    override suspend fun getAllPokemon(): Pokemon = runBlocking(Dispatchers.IO) {
        remoteDataSource.getAllPokemon()
    }

    override suspend fun getStatsPokemonById(id: Int): PokemonStats = runBlocking(Dispatchers.IO) {
        remoteDataSource.getStatsPokemonById(id)
    }
}
