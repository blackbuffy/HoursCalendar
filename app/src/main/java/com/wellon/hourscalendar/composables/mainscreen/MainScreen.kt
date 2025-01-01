package com.wellon.hourscalendar.composables.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold (
    modifier = Modifier.fillMaxSize(),
    topBar = {
        TopBar()
    }
    )

        {

    }
}