package com.wellon.hourscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.wellon.hourscalendar.composables.mainscreen.MainScreen
import com.wellon.hourscalendar.ui.theme.HoursCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val (isDarkTheme, setDarkTheme) = remember {
                mutableStateOf(false)
            }

            HoursCalendarTheme (
                darkTheme = isDarkTheme
            ) {
                MainScreen(MaterialTheme, isDarkTheme, setDarkTheme)
            }
        }
    }
}