package com.example.dicodingtask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun photoDao():PhotoDao
}