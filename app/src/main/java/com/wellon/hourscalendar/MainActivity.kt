package com.wellon.hourscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wellon.hourscalendar.composables.mainscreen.MainScreen
import com.wellon.hourscalendar.ui.theme.HoursCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoursCalendarTheme {
                MainScreen()
            }
        }
    }
}