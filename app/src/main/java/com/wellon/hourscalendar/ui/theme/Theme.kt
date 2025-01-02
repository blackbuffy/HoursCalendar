package com.wellon.hourscalendar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    surface = SurfaceDark,

    primaryContainer = PrimaryContainerDark,
    primary = PrimaryDark,

    tertiary = TertiaryDark
)

private val LightColorScheme = lightColorScheme(
    surface = Surface,

    primaryContainer = PrimaryContainer,
    primary = Primary,

    tertiary = Tertiary
)

@Composable
fun HoursCalendarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}