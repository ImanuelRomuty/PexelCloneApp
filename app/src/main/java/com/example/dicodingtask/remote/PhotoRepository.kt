package com.example.dicodingtask.remote

import com.example.dicodingtask.data.api.response.Photo

class PhotoRepository constructor(private val photoDataSource: PhotoDataSource) {
    fun getPhoto(photoCallBack: PhotoDataSource.PhotoCallBack):List<Photo> = photoDataSource.getPhoto(photoCallBack)
}