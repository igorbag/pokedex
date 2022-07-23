package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.model.Result
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject
import kotlin.random.Random

class GetRandomPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): Result {
        val pokemons = pokemonRepository.getAllPokemon(limit = TOTAL_POKEMONS, offset = INITIAL)
        val randomValue = Random.nextInt(INITIAL, TOTAL_POKEMONS)

        return pokemons.results[randomValue]
    }

    companion object {
        const val TOTAL_POKEMONS = 1154
        const val INITIAL = 0
    }
}
