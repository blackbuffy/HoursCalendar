package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.header.MonthState

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
fun MonthHeader(materialTheme: MaterialTheme, state: MonthState) {
    val currentMonth = state.currentMonth
    val monthValue = currentMonth.monthValue
    val year = currentMonth.year

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { state.currentMonth = state.currentMonth.minusMonths(1) }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Предыдущий месяц",
                tint = materialTheme.colorScheme.tertiary
            )
        }

        Text(
            text = "${russianMonthsMap[monthValue]} $year",
            style = materialTheme.typography.titleMedium,
            color = materialTheme.colorScheme.primary
        )

        IconButton(
            onClick = { state.currentMonth = state.currentMonth.plusMonths(1) }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Следующий месяц",
                tint = materialTheme.colorScheme.tertiary
            )
        }
    }
}