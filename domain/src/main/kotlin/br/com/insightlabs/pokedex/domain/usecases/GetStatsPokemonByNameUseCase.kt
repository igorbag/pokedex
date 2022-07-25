package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.model.PokemonStats
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetStatsPokemonByNameUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): PokemonStats =
        pokemonRepository.getStatsPokemonById(id)
}
