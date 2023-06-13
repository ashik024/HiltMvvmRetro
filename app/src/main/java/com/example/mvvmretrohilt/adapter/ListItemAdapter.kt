package com.example.mvvmretrohilt.adapter


import com.example.mvvmretrohilt.baseItems.BaseListItemCallback
import com.example.mvvmretrohilt.baseItems.MyBaseAdapter
import com.example.mvvmretrohilt.modelClass.ItemClass

import com.example.mvvmretrohilt.R
import com.example.mvvmretrohilt.modelClass.PhotoClass


//class ListItemAdapter(listener: BaseListItemCallback<ItemClass>): MyBaseAdapter<ItemClass>(listener) {
//    override fun getLayoutIdForPosition(position: Int): Int {
//        return R.layout.list_items
//    }
//
//}

class ListItemAdapter(listener: BaseListItemCallback<PhotoClass>): MyBaseAdapter<PhotoClass>(listener) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.list_items
    }

}