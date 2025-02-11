package com.wellon.hourscalendar.composables.calendar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.LocalDate

@Composable
fun Day(
    state: DayState<DynamicSelectionState>,
    onClick: (SelectedDayState) -> Unit = {},
    dates: Map<String, Int>
) {
    val date = state.date
    val selectionState = state.selectionState

    val isSelected = selectionState.isDateSelected(date)

    var hours = 0
    var isWrittenHours = false

    val animatedDayColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
    )

    dates.keys.forEach {
        println(it)
    }

    dates.keys.forEach {
        if (LocalDate.parse(it) == date) {
            isWrittenHours = true
            hours = dates[it]!!.toInt()
        }
    }

    val dayState = SelectedDayState(date, hours)

    Card(
        modifier = Modifier
            .padding(if (isSelected) 2.dp else 4.dp)
            .aspectRatio(2f)
            .graphicsLayer(
                shadowElevation = 4f,
                shape = RoundedCornerShape(8.dp),
                spotShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                ambientShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh
            ),
        shape = RoundedCornerShape(8.dp)
    ) {
        val gradientBrushStart = getGradient(0)
        val gradientBrushEnd = getGradient(hours)



        val modifier = if (isWrittenHours) Modifier
            .animateContentSize()
            .fillMaxSize()
            .clickable {
                onClick(dayState)
                selectionState.onDateSelected(date)
            }
            .background(brush = gradientBrushEnd)
        else Modifier
            .animateContentSize()
            .fillMaxSize()
            .clickable {
                onClick(dayState)
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
                color = animatedDayColor
            )
        }
    }
}

@Composable
fun getGradient(hours: Int): Brush {
    return when (hours) {
        1 -> Brush.linearGradient(
            0.7f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        2 -> Brush.linearGradient(
            0.6f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        3 -> Brush.linearGradient(
            0.5f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        4 -> Brush.linearGradient(
            0.4f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        5 -> Brush.linearGradient(
            0.3f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        6 -> Brush.linearGradient(
            0.2f to MaterialTheme.colorScheme.secondaryContainer,
            1f to Color(0xFFB0E0E6)
        )
        else -> Brush.linearGradient(
            0.3f to MaterialTheme.colorScheme.secondaryContainer,
            1f to MaterialTheme.colorScheme.secondaryContainer
        )
    }
}
