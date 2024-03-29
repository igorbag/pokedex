package br.com.insightlabs.pokedex.remote

sealed class HttpException(
    message: String? = null,
    cause: Throwable? = null
) : Throwable(message, cause)

object AuthenticationException : HttpException()
class UnexpectedException(message: String?) : HttpException()
