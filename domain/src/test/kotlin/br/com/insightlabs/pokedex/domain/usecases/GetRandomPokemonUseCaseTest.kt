package br.com.insightlabs.pokedex.domain.usecases

import br.com.insightlabs.pokedex.domain.factory.PokemonFactory
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExperimentalCoroutinesApi
class GetRandomPokemonUseCaseTest {

    private val repository = mockk<PokemonRepository>()
    private val useCase = GetRandomPokemonUseCase(repository)

    @Test
    fun `Given return all pokemons when GetAllPokemonsUse Case Is called`() = runTest {
        coEvery {
            repository.getAllPokemon(
                limit = any(),
                offset = any()
            )
        } returns PokemonFactory.modelListTotalPokemon

        val result = useCase()

        assertEquals(expected = "Pikachu", actual = result.name)
        assertEquals(expected = "https://pokeapi.co/api/v2/pokemon/1/", actual = result.url)
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
            useCase()
        }
    }

}