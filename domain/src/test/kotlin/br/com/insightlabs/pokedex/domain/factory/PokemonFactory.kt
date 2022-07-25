package br.com.insightlabs.pokedex.domain.factory

import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.model.Result

object PokemonFactory {
    val model = Pokemon(
        results = listOf(
            Result(
                name = "Pikachu",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            )
        )
    )

    val modelListTotalPokemon = Pokemon(
        results = (1..1154).map {
            Result(
                name = "Pikachu",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            )
        }

    )

}