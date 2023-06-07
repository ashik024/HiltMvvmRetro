package com.example.mvvmretrohilt.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException

fun <T>unsafeLazy(initializer: () -> T): Lazy<T>{
    return lazy(LazyThreadSafetyMode.NONE){
        initializer()
    }
}

fun getError(e: Exception): Error {
    e.printStackTrace()
//    CustomAnalytics.logException(e)
    when (e) {
        is HttpException -> {
            return Error(e.code(),e.message.toString())
        }
        is SocketTimeoutException -> {
            return Error(-1, "Connection time out")
        }
        is IOException -> {
            return Error(-1, "Unable to connect server")
        }

        is CancellationException -> {
            return JobCanceledError(-1, "Unknown error occurred")
        }
        else -> {
            return Error(-1, "Unknown error occurred")
        }
    }
}



fun getExternalError(e: Exception): Error {
    e.printStackTrace()
    when (e) {
        is HttpException -> {
            return Error(e.code(), e.message().ifBlank { "Unknown error occurred" })
        }
        is SocketTimeoutException -> {
            return Error(-1, "Timeout")
        }
        is IOException -> {
            return Error(-1, "Unable to connect server.")
        }

        is CancellationException -> {
            return JobCanceledError(-1, "Unknown error occurred")
        }
        else -> {
            return Error(-1, "Unknown error occurred")
        }
    }
}