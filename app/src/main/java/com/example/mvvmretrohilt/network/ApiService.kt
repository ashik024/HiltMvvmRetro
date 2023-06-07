package com.example.mvvmretrohilt.network

import com.example.mvvmretrohilt.modelClass.ItemClass
import retrofit2.http.GET


interface ApiService {

    @GET("posts")
    suspend fun getData(): List<ItemClass>
}