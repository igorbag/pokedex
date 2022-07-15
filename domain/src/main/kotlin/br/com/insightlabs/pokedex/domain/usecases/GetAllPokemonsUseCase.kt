package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): Pokemon =
        pokemonRepository.getAllPokemon()
}
