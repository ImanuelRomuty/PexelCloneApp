package com.example.dicodingtask.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingtask.data.api.response.Photo
import com.example.dicodingtask.remote.PhotoDataSource
import com.example.dicodingtask.remote.PhotoRepository

class HomeViewModel (
    private val repository: PhotoRepository
        ):ViewModel(){
    val photo : MutableLiveData<List<Photo>> by lazy {
        MutableLiveData<List<Photo>>().also {
            getPhoto()
        }
    }
    fun photo(): LiveData<List<Photo>> {
        return photo
    }

    private fun getPhoto() {
        repository.getPhoto(object : PhotoDataSource.PhotoCallBack{
            override fun onComplete(listResult: List<Photo>) {
                photo.value = listResult
            }
            override fun onFailed() {
                Log.d("Error","getPhoto => Error")
            }

        })
    }
}