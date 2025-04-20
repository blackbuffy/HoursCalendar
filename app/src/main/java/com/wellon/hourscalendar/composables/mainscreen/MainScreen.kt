package com.wellon.hourscalendar.composables.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.wellon.hourscalendar.composables.calendar.Calendar
import com.wellon.hourscalendar.composables.calendar.SelectedDayState
import com.wellon.hourscalendar.composables.timepicker.ButtonLog
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun MainScreen(isDarkTheme: Boolean, setDarkTheme: (Boolean) -> Unit, dates: MutableState<Map<String, Int>>) {
    val selectedDate = remember { mutableStateOf(SelectedDayState(LocalDate.now(), 0)) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                SettingsPanel(
                    onClose = { scope.launch { drawerState.close() } },
                    setDarkTheme = setDarkTheme,
                    isDarkTheme = isDarkTheme
                )
            }
        ) {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Ltr
            ) {
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    topBar = {
                        TopBar(
                            onSettingsClick = { scope.launch { drawerState.open()} }
                        )
                    }
                ) { padding ->
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(PaddingValues(top = padding.calculateTopPadding() + 16.dp)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Calendar(
                            onDateSelected = {
                                selectedDate.value = it
                            },
                            dates = dates.value
                        )
                        SummaryCard(selectedDate = selectedDate, dates = dates)
                        ButtonLog(selectedDate = selectedDate, dates = dates)
                    }
                }
            }
        }
    }
}