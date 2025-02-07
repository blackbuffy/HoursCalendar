package com.wellon.hourscalendar.composables.timepicker

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.wellon.hourscalendar.composables.calendar.SelectedDayState
import com.wellon.hourscalendar.composables.timepicker.picker.rememberPickerState
import com.wellon.hourscalendar.db.Date
import com.wellon.hourscalendar.db.DateDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun ButtonLog(selectedDate: MutableState<SelectedDayState>, dates: MutableState<Map<String, Int>>) {
    val (openDialog, setOpenDialog) = remember { mutableStateOf(false) }
    val pickerState = rememberPickerState()
    var selectedHour by remember { mutableIntStateOf(1) }

    val dao = DateDatabase.instance.dateDao()

    val hasHours = dates.value.containsKey(selectedDate.value.date.toString())

    Card (
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .graphicsLayer(
                shadowElevation = 7f,
                shape = RoundedCornerShape(16.dp),
                spotShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                ambientShadowColor = MaterialTheme.colorScheme.surfaceContainerHigh
            )
    ) {
        AnimatedContent(
            targetState = hasHours,
            transitionSpec = {
                slideInHorizontally { width -> width } + fadeIn() togetherWith
                slideOutHorizontally { width -> -width } + fadeOut()
            },
            label = "animka"
        ) { targetHasHours ->
            if (targetHasHours) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    onClick = {
                        TODO()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Удалить часы",
                        tint = MaterialTheme.colorScheme.tertiary
                    )

                    Text(
                        text = "Удалить часы",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            } else {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    onClick = {
                        if (!dates.value.containsKey(selectedDate.value.date.toString())) setOpenDialog(true)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Записать часы",
                        tint = MaterialTheme.colorScheme.tertiary
                    )

                    Text(
                        text = "Записать часы",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }

    val scope = CoroutineScope(EmptyCoroutineContext)

    if (openDialog) {
        TimePickerDialog(
            onDismissRequest = { setOpenDialog(false) },
            confirmButton = {
                Button(
                    onClick = {
                        selectedHour = pickerState.selectedItem.toInt()
                        val date = Date(selectedDate.value.date.toString(), selectedHour)
                        scope.launch(Dispatchers.IO) {
                            dao.insertDate(date)
                            val updatedDates = dao.getAll().associate { it.date to it.hours }
                            dates.value = updatedDates
                        }

                        setOpenDialog(false)
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Text(
                        text = "Готово",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = { setOpenDialog(false) },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Text(
                        text = "Отмена",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        ) {
            HourPicker(pickerState)
        }
    }
}