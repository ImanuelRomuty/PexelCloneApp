package com.example.dicodingtask.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dicodingtask.data.local.Photo
import com.example.dicodingtask.remote.FavoriteDataSource
import com.example.dicodingtask.remote.FavoriteRepository


class DetailViewModel(
    private val favoriteRepository: FavoriteRepository
):ViewModel() {
    fun insertPhoto(photo: Photo){
        favoriteRepository.insertPhoto(object : FavoriteDataSource.AddCallBack{
            override fun onComplete(result: Long) {
                Log.d("Complete" , "Complete Insert Data")
            }

        },photo)
    }
}