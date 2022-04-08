package br.com.insightlabs.pokedex.usecases

import br.com.insightlabs.pokedex.model.Pokemon
import br.com.insightlabs.pokedex.repositories.PokemonRepository

class GetAllPokemonsUseCase(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): List<Pokemon> =
        pokemonRepository.getAllPokemon()
}
