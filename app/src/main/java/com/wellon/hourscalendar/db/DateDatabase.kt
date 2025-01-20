package com.wellon.hourscalendar.db

import android.content.Context
import androidx.room.Room

object DateDatabase {
    lateinit var instance: AppDatabase
        private set

    fun initialize(context: Context) {
        instance = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "date-database"
        ).build()
    }
}