package br.com.insightlabs.pokedex.domain.factory

import br.com.insightlabs.pokedex.domain.model.PokemonStats
import br.com.insightlabs.pokedex.domain.model.Stat
import br.com.insightlabs.pokedex.domain.model.Stats

object PokemonStatsFactory {

    val pokemonStats = PokemonStats(
        id = 0,
        name = "pokemon",
        stats = listOf(
            Stats(
                baseStat = 10,
                effort = 10,
                stat = Stat(name = "power", url = "url")
            )

        )
    )
}
