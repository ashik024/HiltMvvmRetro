package com.example.mvvmretrohilt.repository

import com.example.mvvmretrohilt.modelClass.ItemClass
import com.example.mvvmretrohilt.network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiServiceImp: ApiServiceImp) {

    fun getDatas() : kotlinx.coroutines.flow.Flow<List<ItemClass>> = flow {

     emit(apiServiceImp.getAllData())

    }.flowOn(Dispatchers.IO)

    }