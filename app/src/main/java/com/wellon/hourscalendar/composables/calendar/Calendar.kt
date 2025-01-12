package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import java.time.DayOfWeek

@Composable
fun Calendar() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .graphicsLayer(
                shadowElevation = 7f,
                shape = RoundedCornerShape(16.dp),
                spotShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                ambientShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh
            )
    ) {
        SelectableCalendar(
            monthHeader = {
                MonthHeader(it)
            },
            daysOfWeekHeader = {
                DaysOfWeekHeader(it)
            },
            dayContent = {
                Day(it)
            },
            firstDayOfWeek = DayOfWeek.MONDAY,
            showAdjacentMonths = false
        )
    }
}