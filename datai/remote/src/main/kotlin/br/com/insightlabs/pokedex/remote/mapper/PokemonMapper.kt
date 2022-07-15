package br.com.insightlabs.pokedex.remote.mapper

import br.com.insightlabs.pokedex.remote.model.Pokemon
import br.com.insightlabs.pokedex.remote.model.Result
import br.com.insightlabs.pokedex.domain.model.Pokemon as PokemonDomain
import br.com.insightlabs.pokedex.domain.model.Result as ResultDomain

fun Pokemon.toDomain() = PokemonDomain(
    results = results.map { it.toDomain() }
)

fun Result.toDomain() = ResultDomain(
    name = name,
    url = url
)
