package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.factory.PokemonFactory.model
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
class GetAllPokemonsUseCaseTest {

    private val repository = mockk<PokemonRepository>()
    private val useCase = GetAllPokemonsUseCase(repository)

    @Test
    fun `Given return all pokemons when GetAllPokemonsUse Case Is called`() = runTest {
        coEvery { repository.getAllPokemon(limit = any(), offset = any()) } returns model

        val pokemons = useCase(limit = 0, offset = 0)

        coVerify(exactly = 1) { repository.getAllPokemon(any(), any()) }
        assertEquals(expected = 1, actual = pokemons.results.size)
    }

    @Test
    fun `Given return throws an exception Then should throw the exception`() = runTest {
        coEvery {
            repository.getAllPokemon(
                limit = any(),
                offset = any()
            )
        } throws Throwable("system exception")

        assertFailsWith<Throwable>("any exception") {
            useCase(0, 0)
        }

        coVerify(exactly = 1) { repository.getAllPokemon(0, 0) }
    }

}