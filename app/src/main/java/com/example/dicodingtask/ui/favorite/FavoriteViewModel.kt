package com.example.dicodingtask.ui.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingtask.data.local.Photo
import com.example.dicodingtask.remote.FavoriteDataSource
import com.example.dicodingtask.remote.FavoriteRepository

class FavoriteViewModel  (
    private val repository: FavoriteRepository
): ViewModel() {
    private val photoSplash : MutableLiveData<List<Photo>> by lazy {
        MutableLiveData<List<Photo>>().also {
            favoritePhoto()
        }
    }
    fun photo(): LiveData<List<Photo>> {
        return photoSplash
    }
    fun favoritePhoto(){
        repository.getFavorite(object : FavoriteDataSource.PhotoCallBack{
            override fun onComplete(listResult: List<Photo>) {
                photoSplash.value = listResult
                Log.d("FavoriteFragment","sukses")
            }

            override fun onFailed() {
                Log.d("FavoriteFragment","error")
            }

        })
    }
}