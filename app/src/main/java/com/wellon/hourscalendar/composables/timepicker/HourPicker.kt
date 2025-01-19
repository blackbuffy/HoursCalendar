package com.wellon.hourscalendar.composables.timepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wellon.hourscalendar.composables.timepicker.picker.Picker
import com.wellon.hourscalendar.composables.timepicker.picker.rememberPickerState

@Composable
fun HourPicker() {
    val state = rememberPickerState()
    val items = remember { (1..6).map { it.toString() } }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Picker(
            state = state,
            items = items,
            visibleItemsCount = 3,
            textStyle = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.primary),
            dividerColor = MaterialTheme.colorScheme.tertiary
        )
    }
}