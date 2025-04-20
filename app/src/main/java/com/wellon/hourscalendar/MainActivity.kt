package com.wellon.hourscalendar

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.wellon.hourscalendar.composables.mainscreen.MainScreen
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
            val themePreference = remember { ThemePreference(applicationContext) }

            val (isDarkTheme, setDarkTheme) = remember {
                mutableStateOf(themePreference.getDarkThemeState())
            }

            DateDatabase.initialize(applicationContext)
            val dao = DateDatabase.instance.dateDao()

            val dates = remember { mutableStateOf(mapOf<String, Int>()) }
            val scope = CoroutineScope(EmptyCoroutineContext)
            LaunchedEffect(Unit) {
                scope.launch(Dispatchers.IO) {
                    val map = dao.getAll().associate { it.date to it.hours }
                    dates.value = map
                }
            }
            
            HoursCalendarTheme (
                darkTheme = isDarkTheme,
            ) {
                MainScreen(
                    isDarkTheme,
                    setDarkTheme = { newValue ->
                        setDarkTheme(newValue)
                        themePreference.saveDarkThemeState(newValue)
                    },
                    dates
                )
            }
        }
    }
}

class ThemePreference(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("app_theme", Context.MODE_PRIVATE)

    fun saveDarkThemeState(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean("dark_theme", isEnabled).apply()
    }

    fun getDarkThemeState(): Boolean {
        return sharedPreferences.getBoolean("dark_theme", false)
    }
}
