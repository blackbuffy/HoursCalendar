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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    TopAppBar(
        title = {
            Text(
                text = "Календарь часов",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "иконка календарика",
                tint = MaterialTheme.colorScheme.tertiary
            )
        },
        actions = {
            IconButton(onClick = { TODO() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "иконка настроек",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .graphicsLayer(
                shadowElevation = 7f
            )
    )
}