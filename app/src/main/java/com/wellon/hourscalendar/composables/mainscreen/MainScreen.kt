package com.wellon.hourscalendar.composables.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wellon.hourscalendar.composables.calendar.Calendar
import com.wellon.hourscalendar.composables.timepicker.ButtonLog
import java.time.LocalDate

@Composable
fun MainScreen(isDarkTheme: Boolean, setDarkTheme: (Boolean) -> Unit) {
    var selectedDate = remember { mutableStateOf<LocalDate?>(null) }

    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { TopBar() }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(top = it.calculateTopPadding() + 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Calendar(onDateSelected = { selectedDate.value = it })
            SummaryCard()
            ButtonLog(selectedDate = selectedDate)
        }
    }
}