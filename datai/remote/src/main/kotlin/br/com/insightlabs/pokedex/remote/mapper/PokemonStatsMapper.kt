package br.com.insightlabs.pokedex.remote.mapper

import br.com.insightlabs.pokedex.remote.model.PokemonStats
import br.com.insightlabs.pokedex.remote.model.Stat
import br.com.insightlabs.pokedex.remote.model.Stats
import br.com.insightlabs.pokedex.domain.model.PokemonStats as PokemonStatsDomain
import br.com.insightlabs.pokedex.domain.model.Stat as StatDomain
import br.com.insightlabs.pokedex.domain.model.Stats as StatsDomain

fun PokemonStats.toDomain() = PokemonStatsDomain(
    id = 0,
    name = "",
    stats = stats.map {
        it.toDomain()
    }
)

fun Stat.toDomain() = StatDomain(
    name = name,
    url = url
)

fun Stats.toDomain() = StatsDomain(
    baseStat = baseStat,
    effort = effort,
    stat = stat.toDomain()
)
