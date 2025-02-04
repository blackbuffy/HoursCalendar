package com.wellon.hourscalendar.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Date(
    @PrimaryKey val date: String,
    @ColumnInfo(name = "hours") var hours: Int
)