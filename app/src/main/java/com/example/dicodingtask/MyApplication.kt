package com.example.dicodingtask

import android.app.Application
import com.example.dicodingtask.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                viewModelModule,
                repositoryModule,
                networkModule,
                remoteDataSourceModule,
                localModule
            )
        }
    }

}