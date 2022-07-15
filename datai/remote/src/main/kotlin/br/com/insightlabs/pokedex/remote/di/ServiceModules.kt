package br.com.insightlabs.pokedex.remote.di

import br.com.insightlabs.pokedex.remote.service.PokemonService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class ServiceModules {

    @Provides
    fun providePokemonService(retrofit: Retrofit) = retrofit.create<PokemonService>()
}
