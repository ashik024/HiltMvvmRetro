package com.example.mvvmretrohilt.network

import com.example.mvvmretrohilt.modelClass.ItemClass
import com.example.mvvmretrohilt.modelClass.PhotoClass
import javax.inject.Inject



class ApiServiceImp
@Inject
constructor(private val apiService: ApiService){


    suspend fun getAllData(): List<ItemClass> {

        val response = apiService.getData()

         return response
    }

    suspend fun getAllPhotos(): List<PhotoClass> {

        val response = apiService.getPhotos()

        return response
    }
}