package com.wellon.hourscalendar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.DefaultShadowColor

private val DarkColorScheme = darkColorScheme(
    surface = SurfaceDark,

    primaryContainer = PrimaryContainerDark,
    primary = PrimaryDark,

    onPrimary = OnPrimaryDark,

    secondaryContainer = SecondaryContainerDark,

    tertiary = TertiaryDark,

    tertiaryContainer = DarkTertiaryContainer,

    surfaceContainerHigh = SurfaceContainerHighDark
)

private val LightColorScheme = lightColorScheme(
    surface = Surface,

    primaryContainer = PrimaryContainer,
    primary = Primary,

    onPrimary = OnPrimary,

    secondaryContainer = SecondaryContainer,

    tertiary = Tertiary,

    tertiaryContainer = TertiaryContainer,

    surfaceContainerHigh = DefaultShadowColor
)

@Composable
fun HoursCalendarTheme(
    darkTheme: Boolean = false,
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