package com.example.notepad.data.db

import android.content.Context
import androidx.room.Room

object AppDatabaseInstance {
    var instance: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase {
        instance?.let { return it }
           return   Room.databaseBuilder(
                context,
                AppDatabase::class.java, "notepad-database"
            ).build()
    }

}