package com.example.mvvmretrohilt.modelClass

import android.os.Parcelable
import com.google.android.gms.common.annotation.KeepName
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@KeepName
@Parcelize
data class PhotoClass (

    @SerializedName("albumId")
    val albumId: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String

) : Parcelable