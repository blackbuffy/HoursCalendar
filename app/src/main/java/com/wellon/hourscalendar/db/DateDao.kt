package com.wellon.hourscalendar.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DateDao {
    @Query("SELECT * FROM date")
    fun getAll(): List<Date>

    @Query("SELECT * FROM date WHERE date = :date")
    fun getDate(date: String): Date?

    @Insert
    fun insertDate(date: Date)

    @Delete
    fun deleteDate(date: Date)
}