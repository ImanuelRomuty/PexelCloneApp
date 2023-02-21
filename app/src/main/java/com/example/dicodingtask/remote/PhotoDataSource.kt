package com.example.dicodingtask.remote

import com.example.dicodingtask.data.api.response.Photo
import com.example.dicodingtask.data.api.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PhotoDataSource(private val apiService: ApiService) {
    interface PhotoCallBack{
        fun onComplete(listResult : List<Photo>)
        fun onFailed()
    }
    fun getPhoto(photoCallBack: PhotoCallBack):List<Photo>{
        GlobalScope.launch(Dispatchers.IO){
            val response = apiService.allPhoto()
            runBlocking(Dispatchers.Main){
                val result = response.body()
                result.let {
                    if(it!=null){
                        photoCallBack.onComplete(it.photos)
                    }
                }
            }
        }
        return emptyList()
    }
}