package com.wellon.hourscalendar.composables.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wellon.hourscalendar.composables.calendar.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(materialTheme: MaterialTheme, isDarkTheme: Boolean, setDarkTheme: (Boolean) -> Unit) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = materialTheme.colorScheme.surface,
        topBar = { TopBar(materialTheme, isDarkTheme) }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(top = it.calculateTopPadding() + 8.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Calendar(materialTheme)
        }
    }
}