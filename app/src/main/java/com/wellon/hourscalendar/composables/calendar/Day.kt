package com.wellon.hourscalendar.composables.calendar

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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import java.time.LocalDate

@Composable
fun Day(
    state: DayState<DynamicSelectionState>,
    onClick: (LocalDate) -> Unit = {}
) {
    val date = state.date
    val selectionState = state.selectionState

    val isSelected = selectionState.isDateSelected(date)

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
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick(date)
                    selectionState.onDateSelected(date)
                }
        ) {
            Text(
                text = state.date.dayOfMonth.toString(),
                style = if (isSelected) MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold) else MaterialTheme.typography.titleSmall,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
            )
        }
    }
}