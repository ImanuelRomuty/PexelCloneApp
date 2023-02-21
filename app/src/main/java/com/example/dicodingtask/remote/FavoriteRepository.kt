package com.example.dicodingtask.remote

import com.example.dicodingtask.data.local.Photo


class FavoriteRepository constructor(private val photoDataSource: FavoriteDataSource) {
    fun  insertPhoto(addCallBack: FavoriteDataSource.AddCallBack,favoritePhoto: Photo):Long=
        photoDataSource.insertFavorite(addCallBack,favoritePhoto)
    fun getFavorite(photoCallBack: FavoriteDataSource.PhotoCallBack):List<Photo> =
        photoDataSource.getAllFavorite(photoCallBack)
}