package com.example.mvvmretrohilt.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData

import kotlinx.coroutines.Dispatchers



fun <T> resultLiveData(networkCall: suspend () -> T): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        try {
            val response = networkCall.invoke()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Failure<T>(getError(e)))
        }
    }

suspend fun <T> resultFromResponse(networkCall: suspend () -> T): Resource<T> =
    try {
        val response = networkCall.invoke()
        Resource.Success(response)
    } catch (e: Exception) {
        Resource.Failure<T>(getError(e))
    }

suspend fun <T> resultFromExternalResponse(networkCall: suspend () -> T): Resource<T> =
    try {
        val response = networkCall.invoke()
        Resource.Success(response)
    } catch (e:Exception){
        Resource.Failure(getExternalError(e))
    }