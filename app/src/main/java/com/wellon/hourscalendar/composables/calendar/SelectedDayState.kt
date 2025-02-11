package com.wellon.hourscalendar.composables.calendar

import java.time.LocalDate

data class SelectedDayState(
    var date: LocalDate,
    var hours: Int
)