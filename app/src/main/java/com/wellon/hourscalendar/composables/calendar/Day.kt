package com.wellon.hourscalendar.composables.calendar

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
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState

@Composable
fun Day(materialTheme: MaterialTheme, state: DayState<DynamicSelectionState>) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .aspectRatio(2f)
            .graphicsLayer(
                shadowElevation = 4f,
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = materialTheme.colorScheme.primaryContainer)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = state.date.dayOfMonth.toString(),
                style = materialTheme.typography.titleSmall,
                color = materialTheme.colorScheme.primary
            )
        }
    }
}