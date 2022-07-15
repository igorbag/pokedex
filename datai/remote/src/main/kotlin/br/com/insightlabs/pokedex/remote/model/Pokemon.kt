package br.com.insightlabs.pokedex.remote.model

data class Pokemon(
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)
