package br.com.insightlabs.pokedex.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

suspend fun <T, R> T.runCatching(
    dispatcher: CoroutineDispatcher,
    execute: suspend () -> R,
    onSuccess: (R) -> Unit = {},
    onFailure: (Throwable) -> Unit = {}
) {
    runCatching {
        withContext(dispatcher) {
            execute()
        }
    }.onSuccess(onSuccess)
        .onFailure {
            Timber.e(it)
            onFailure(it)
        }
}