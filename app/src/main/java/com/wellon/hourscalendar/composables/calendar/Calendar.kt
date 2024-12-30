package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar

@Composable
fun Calendar(materialTheme: MaterialTheme) {
    SelectableCalendar(
        monthContainer = { content ->
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) { content(PaddingValues()) }
        },
        monthHeader = {
            MonthHeader(it.currentMonth.monthValue, it.currentMonth.year, materialTheme)
        },
        daysOfWeekHeader = {
            DaysOfWeekHeader(it, materialTheme)
        }
    )
}