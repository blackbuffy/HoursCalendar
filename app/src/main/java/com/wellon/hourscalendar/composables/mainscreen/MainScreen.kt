package com.wellon.hourscalendar.composables.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wellon.hourscalendar.composables.calendar.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(materialTheme: MaterialTheme) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Calendar(materialTheme)
    }
}