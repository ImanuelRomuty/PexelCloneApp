package com.example.dicodingtask.di

import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.dicodingtask.data.api.service.ApiService
import com.example.dicodingtask.data.local.ApplicationDatabase
import com.example.dicodingtask.remote.FavoriteDataSource
import com.example.dicodingtask.remote.PhotoDataSource
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val localModule = module {
    factory { get<ApplicationDatabase>().photoDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ApplicationDatabase::class.java, "PhotoPexelsDicodingTask12.db").fallbackToDestructiveMigration().build()
    }
}


val networkModule= module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(
                ChuckerInterceptor.Builder(androidContext())
                    .collector(ChuckerCollector(androidContext()))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.pexels.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }

}
val remoteDataSourceModule = module {
    single { PhotoDataSource(get()) }
    single { FavoriteDataSource(get()) }
}