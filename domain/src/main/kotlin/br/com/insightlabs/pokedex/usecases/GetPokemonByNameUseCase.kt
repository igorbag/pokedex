package br.com.insightlabs.pokedex.usecases

import br.com.insightlabs.pokedex.model.Pokemon
import br.com.insightlabs.pokedex.repositories.PokemonRepository

class GetPokemonByNameUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(name: String): Pokemon =
        pokemonRepository.getPokemonByName(name)
}
