package br.com.insightlabs.pokedex.domain.model

data class PokemonStats(
    var id : Int,
    var name : String,
    val stats: List<Stats>
)

data class Stats(
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)