package com.example.mvvmretrohilt.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrohilt.modelClass.ItemClass
import com.example.mvvmretrohilt.network.ApiServiceImp
import com.example.mvvmretrohilt.utils.Resource
import com.example.mvvmretrohilt.utils.SingleLiveEvent
import com.example.mvvmretrohilt.utils.resultFromResponse

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DataViewModel
@Inject constructor(  val apiServiceImp: ApiServiceImp)
    : ViewModel(){

    val dataList = SingleLiveEvent<Resource<List<ItemClass>>>()


    fun loadDataViewModel() {
        viewModelScope.launch {
            val response = resultFromResponse { apiServiceImp.getAllData() }
            dataList.postValue(response)
        }
    }

}