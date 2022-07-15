package br.com.insightlabs.pokedex.di

import br.com.insightlabs.pokedex.data.di.DataModule
import br.com.insightlabs.pokedex.remote.di.NetworkModule
import br.com.insightlabs.pokedex.remote.di.RemoteModule
import br.com.insightlabs.pokedex.remote.di.ServiceModules
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module(
    includes = [
        DataModule::class,
        RemoteModule::class,
        NetworkModule::class,
        ServiceModules::class,
    ]
)
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @CoroutineDispatcherDefault
    fun provideDispatcherDefault(): CoroutineDispatcher {
        return Dispatchers.Default
    }

}