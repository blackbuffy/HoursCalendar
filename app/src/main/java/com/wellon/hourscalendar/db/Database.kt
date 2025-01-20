package com.wellon.hourscalendar.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Date::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dateDao(): DateDao
}