package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.DayOfWeek
import java.time.LocalDate

@Composable
fun Calendar(onDateSelected: (SelectedDayState) -> Unit, dates: Map<String, Int>) {
    val calendarState = rememberSelectableCalendarState(initialSelectionMode = SelectionMode.Single)

    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

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
            calendarState = calendarState,
            monthHeader = {
                MonthHeader(it)
            },
            daysOfWeekHeader = {
                DaysOfWeekHeader(it)
            },
            dayContent = {
                Day(
                    state = it,
                    onClick = { date ->
                        selectedDate = date.date
                        onDateSelected(date)
                    },
                    dates = dates
                )
            },
            firstDayOfWeek = DayOfWeek.MONDAY,
            showAdjacentMonths = false
        )
    }
}

