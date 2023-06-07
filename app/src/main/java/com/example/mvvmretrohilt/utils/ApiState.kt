package com.example.mvvmretrohilt.utils

import com.example.mvvmretrohilt.modelClass.ItemClass

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<ItemClass>) : ApiState()
    object Empty : ApiState()
}