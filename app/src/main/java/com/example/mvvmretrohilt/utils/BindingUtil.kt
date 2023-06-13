package com.example.mvvmretrohilt.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.imageLoader
import coil.load
import coil.request.Disposable
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.mvvmretrohilt.modelClass.PhotoClass
import com.example.mvvmretrohilt.widget.px
import javax.inject.Singleton
import kotlin.math.min


@Singleton
class BindingUtil {

    companion object {
        @JvmStatic
        @BindingAdapter("loadChannelImage")
        fun bindChannel(view: ImageView, photoClass: PhotoClass?) {
            view.load(photoClass?.url) {

//                transformations(CircleCropTransformation())
                size(min(80.px, 150), min(80.px, 150))
            }
        }
    }



}