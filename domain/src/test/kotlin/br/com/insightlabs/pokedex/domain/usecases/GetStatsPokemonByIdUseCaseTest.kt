package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.factory.PokemonStatsFactory.pokemonStats
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExperimentalCoroutinesApi
class GetStatsPokemonByNameUseCaseTest {

    private val repository = mockk<PokemonRepository>()
    private val useCase = GetStatsPokemonByNameUseCase(repository)

    @Test
    fun `Given return all pokemon stats when GetStatsPokemonByNameUseCase Case Is called`() = runTest {
        coEvery { repository.getStatsPokemonById(id = any()) } returns pokemonStats

        val stats = useCase(1)

        coVerify(exactly = 1) { repository.getStatsPokemonById(any()) }
        assertEquals(expected = 0, actual = stats.id)
        assertEquals(expected = "pokemon", actual = stats.name)
        assertEquals(expected = 1, actual = stats.stats.size)
    }

    @Test
    fun `Given return throwable when GetAllPokemonsUse Case Is called`() = runTest {
        coEvery { repository.getStatsPokemonById(id = any()) } throws Throwable("system exception")

        assertFailsWith<Throwable>("any exception") {
            useCase(1)
        }
    }

}