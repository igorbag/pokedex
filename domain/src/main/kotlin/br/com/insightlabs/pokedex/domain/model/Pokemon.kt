package br.com.insightlabs.pokedex.domain.model

import java.io.Serializable

data class Pokemon(
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
) : Serializable {

    val id = url.split("/".toRegex()).dropLast(1).last().toInt()

    fun imageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}
