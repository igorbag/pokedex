package br.com.insightlabs.pokedex.remote.extensions

import br.com.insightlabs.pokedex.remote.AuthenticationException
import br.com.insightlabs.pokedex.remote.UnexpectedException
import retrofit2.HttpException as RetrofitHttpException

internal fun <T> Result<T>.getOrThrowDomainError(): T {
    return getOrElse { throw it.toDomainError() }
}

internal fun Throwable.toDomainError(): Throwable {
    return when (this) {
        is RetrofitHttpException -> {
            when (code()) {
                401 -> AuthenticationException
                else -> UnexpectedException(message())
            }
        }
        else -> this
    }
}
