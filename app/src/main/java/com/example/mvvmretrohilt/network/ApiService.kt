package com.example.mvvmretrohilt.network

import com.example.mvvmretrohilt.modelClass.ItemClass
import com.example.mvvmretrohilt.modelClass.PhotoClass
import retrofit2.http.GET


interface ApiService {

    @GET("posts")
    suspend fun getData(): List<ItemClass>

    @GET("photos")
    suspend fun getPhotos(): List<PhotoClass>
}