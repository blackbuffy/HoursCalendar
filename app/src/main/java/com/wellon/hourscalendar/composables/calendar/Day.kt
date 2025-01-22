package com.wellon.hourscalendar.composables.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wellon.hourscalendar.db.Date
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.LocalDate

@Composable
fun Day(
    state: DayState<DynamicSelectionState>,
    onClick: (LocalDate) -> Unit = {},
    dates: MutableList<String>,
    isDarkTheme: Boolean
) {
    val date = state.date
    val selectionState = state.selectionState

    val isSelected = selectionState.isDateSelected(date)


    var isWrittenHours = false
    dates.forEach {
        if (LocalDate.parse(it) == date) isWrittenHours = true
        println(it)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .aspectRatio(2f)
            .graphicsLayer(
                shadowElevation = 4f,
                shape = RoundedCornerShape(8.dp),
                spotShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                ambientShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        val gradientBrush = Brush.linearGradient(
            0.3f to MaterialTheme.colorScheme.secondaryContainer,
            0.6f to Color(0xFFB0E0E6),
            0.8f to Color(0xFF87CEEB),
            1f to Color(0xFF4682B4)
        )

        val modifier = if (isWrittenHours) Modifier
            .fillMaxSize()
            .clickable {
                onClick(date)
                selectionState.onDateSelected(date)
            }
            .background(brush = gradientBrush)
        else Modifier
            .fillMaxSize()
            .clickable {
                onClick(date)
                selectionState.onDateSelected(date)
            }
            .background(color = MaterialTheme.colorScheme.secondaryContainer)

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            Text(
                text = state.date.dayOfMonth.toString(),
                style = if (isSelected) MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold) else MaterialTheme.typography.titleSmall,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
            )
        }
    }
}