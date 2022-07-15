package br.com.insightlabs.pokedex.data.di

import br.com.insightlabs.pokedex.data.repositories.PokemonRepositoryImpl
import br.com.insightlabs.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun providesPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}
