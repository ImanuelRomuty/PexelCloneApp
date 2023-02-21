package com.example.dicodingtask.data.local

import androidx.room.*


@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo ")
    fun getPhoto(): List<Photo>

    @Update
    fun updatePhoto(photo: Photo) : Int

    @Query("INSERT OR REPLACE INTO Photo VALUES(:id , :imagePath , :photographerName , :photographerUrl , :alt)")
    fun addPhoto(id:Int,imagePath:String?=null , photographerName:String?=null, photographerUrl:String?=null, alt:String?=null) : Long

}