package br.com.insightlabs.pokedex.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonStats(
    val stats: List<Stats>
)

data class Stats(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)
