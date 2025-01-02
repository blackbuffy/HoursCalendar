package com.wellon.hourscalendar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.wellon.hourscalendar.R

val shriftFamily = FontFamily(
    Font(R.font.shrift)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = shriftFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp
    ),
    titleMedium = TextStyle(
        fontFamily = shriftFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = shriftFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 14.sp
    )
)