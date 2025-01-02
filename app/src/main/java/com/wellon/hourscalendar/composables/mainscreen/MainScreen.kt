package com.wellon.hourscalendar.composables.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
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
fun MainScreen(materialTheme: MaterialTheme) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = materialTheme.colorScheme.surface,
        topBar = { TopBar(materialTheme) }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = materialTheme.colorScheme.tertiary
            )

            Calendar(materialTheme)
        }
    }
}