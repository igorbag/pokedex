package br.com.insightlabs.pokedex.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class CoroutineDispatcherDefault
