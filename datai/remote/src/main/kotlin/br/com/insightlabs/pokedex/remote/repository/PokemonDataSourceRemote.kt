package br.com.insightlabs.pokedex.remote.repository

import br.com.insightlabs.pokedex.data.source.PokemonDataSource
import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.PokemonStats
import br.com.insightlabs.pokedex.remote.extensions.getOrThrowDomainError
import br.com.insightlabs.pokedex.remote.mapper.toDomain
import br.com.insightlabs.pokedex.remote.service.PokemonService
import javax.inject.Inject

class PokemonDataSourceRemote @Inject constructor(
    private val service: PokemonService
) : PokemonDataSource.Remote {

    override suspend fun getAllPokemon(
        limit: Int,
        offset: Int
    ): Pokemon {
        return runCatching { service.getAllPokemon(limit, offset) }
            .getOrThrowDomainError()
            .toDomain()
    }

    override suspend fun getStatsPokemonById(id: Int): PokemonStats {
        return runCatching { service.getStatsPokemonById(id) }
            .getOrThrowDomainError()
            .toDomain()
    }
}
