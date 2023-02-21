package com.example.dicodingtask.di

import com.example.dicodingtask.remote.FavoriteRepository
import com.example.dicodingtask.remote.PhotoRepository
import com.example.dicodingtask.ui.detail.DetailViewModel
import com.example.dicodingtask.ui.favorite.FavoriteViewModel
import com.example.dicodingtask.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel{DetailViewModel(get())}
    viewModel {FavoriteViewModel(get())}
}