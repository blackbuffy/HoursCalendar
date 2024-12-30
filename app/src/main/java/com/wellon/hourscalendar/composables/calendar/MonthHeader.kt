package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val russianMonthsMap = mapOf(
    1 to "Январь",
    2 to "Февраль",
    3 to "Март",
    4 to "Апрель",
    5 to "Май",
    6 to "Июнь",
    7 to "Июль",
    8 to "Август",
    9 to "Сентябрь",
    10 to "Октябрь",
    11 to "Ноябрь",
    12 to "Декабрь"
)

@Composable
fun MonthHeader(monthValue: Int, year: Int, materialTheme: MaterialTheme) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${russianMonthsMap[monthValue]} $year",
            style = materialTheme.typography.titleMedium,
            color = materialTheme.colorScheme.secondary
        )
    }
}