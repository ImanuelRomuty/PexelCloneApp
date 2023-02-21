package com.example.dicodingtask.remote

import com.example.dicodingtask.data.local.Photo
import com.example.dicodingtask.data.local.PhotoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FavoriteDataSource(private val favoriteDao: PhotoDao) {
    interface PhotoCallBack{
        fun onComplete(listResult : List<Photo>)
        fun onFailed()
    }
    interface AddCallBack{
        fun onComplete(result:Long)
    }
    fun getAllFavorite(favoriteCallBack: PhotoCallBack):List<Photo>{
        GlobalScope.launch(Dispatchers.IO){
            val result = favoriteDao.getPhoto()
            runBlocking(Dispatchers.Main){
                favoriteCallBack.onComplete(result)
            }
        }
    return emptyList()
    }
    fun insertFavorite(favoriteCallBack: AddCallBack,favoritePhoto:Photo):Long{
        GlobalScope.launch(Dispatchers.IO){
            val result = favoriteDao.addPhoto(
                favoritePhoto.id,
                favoritePhoto.imagePath,
                favoritePhoto.name,
                favoritePhoto.url,
                favoritePhoto.alt
                )
            runBlocking(Dispatchers.Main){
                favoriteCallBack.onComplete(result)
            }
        }
        return 0
    }
}