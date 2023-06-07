package com.example.mvvmretrohilt.baseItems

import android.view.ContentInfo
import android.view.View

interface OptionCallBack {
    fun onOptionClicked(anchor: View, contentInfo: ContentInfo)
    fun viewAllVideoClick()
}