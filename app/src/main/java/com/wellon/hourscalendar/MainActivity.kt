package com.wellon.hourscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.wellon.hourscalendar.composables.mainscreen.MainScreen
import com.wellon.hourscalendar.db.Date
import com.wellon.hourscalendar.db.DateDatabase
import com.wellon.hourscalendar.ui.theme.HoursCalendarTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val (isDarkTheme, setDarkTheme) = remember {
                mutableStateOf(true)
            }

            DateDatabase.initialize(applicationContext)
            val dao = DateDatabase.instance.dateDao()

            var dates = remember { mutableListOf<String>() }
            val scope = CoroutineScope(EmptyCoroutineContext)
            LaunchedEffect(Unit) {
                scope.launch(Dispatchers.IO) {
                    val list = dao.getAll().map { it.date }
                    dates = list.toMutableList()
                }
            }
            
            HoursCalendarTheme (
                darkTheme = isDarkTheme
            ) {
                MainScreen(isDarkTheme, setDarkTheme, dates)
            }
        }
    }
}