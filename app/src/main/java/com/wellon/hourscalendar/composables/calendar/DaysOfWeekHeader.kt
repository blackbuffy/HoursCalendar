package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DaysOfWeekHeader(days: List<DayOfWeek>, materialTheme: MaterialTheme) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        days.forEach { day ->
            Text(
                text = day.getDisplayName(TextStyle.SHORT, Locale("ru")),
                style = materialTheme.typography.titleSmall,
                color = materialTheme.colorScheme.secondary
            )
        }
    }
}