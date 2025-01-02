package com.wellon.hourscalendar.composables.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(materialTheme: MaterialTheme) {
    TopAppBar(
        title = {
            Text(
                text = "Календарь часов",
                style = materialTheme.typography.titleLarge,
                color = materialTheme.colorScheme.primary
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "иконка календарика",
                tint = materialTheme.colorScheme.tertiary
            )
        },
        actions = {
            IconButton(onClick = { TODO() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "иконка настроек",
                    tint = materialTheme.colorScheme.tertiary
                )
            }
        }
    )
}