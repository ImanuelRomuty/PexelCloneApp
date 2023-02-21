package com.example.dicodingtask.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class Photo(
    @PrimaryKey    var id : Int,
    @ColumnInfo(name=  "imagepath")     var imagePath: String? = null,
    @ColumnInfo(name = "photographerName") var name : String?=null,
    @ColumnInfo(name = "photographerUrl") var url : String?=null,
    @ColumnInfo(name = "alt") var alt : String?=null
): Parcelable