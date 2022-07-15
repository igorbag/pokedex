package br.com.insightlabs.pokedex.remote.di

import br.com.insightlabs.pokedex.data.source.PokemonDataSource
import br.com.insightlabs.pokedex.remote.repository.PokemonDataSourceRemote
import dagger.Binds
import dagger.Module

@Module
interface RemoteModule {

    @Binds
    fun providesPokemonRepository(impl: PokemonDataSourceRemote): PokemonDataSource.Remote
}
