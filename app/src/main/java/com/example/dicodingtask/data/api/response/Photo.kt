package com.example.dicodingtask.data.api.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    @SerializedName("alt")
    val alt: String?=null,
    @SerializedName("avg_color")
    val avgColor: String?=null,
    @SerializedName("height")
    val height: Int?=null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photographer")
    val photographer: String?=null,
    @SerializedName("photographer_id")
    val photographerId: Int?=null,
    @SerializedName("photographer_url")
    val photographerUrl: String?=null,
    @SerializedName("src")
    val src: Src?=null,
    @SerializedName("url")
    val url: String?=null,
    @SerializedName("width")
    val width: Int?=null
):Parcelable