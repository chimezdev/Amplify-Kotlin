package com.example.shirtersdroid.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.shirtersdroid.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// Define the FontFamily with appropriate weights
val epilogueFontFamily = FontFamily(
    Font(R.font.epilogue_regular, FontWeight.W400),
    Font(R.font.epilogue_bold, FontWeight.Bold),
    Font(R.font.epilogue_extrabold, FontWeight.W800),
    Font(R.font.epilogue_semibold, FontWeight.W600)
)

val heading1 = TextStyle(
    fontFamily = epilogueFontFamily,
    fontWeight = FontWeight.W800,
    fontSize = 36.sp,
    lineHeight = 45.sp
)

val heading2 = TextStyle(
    fontFamily = epilogueFontFamily,
    fontWeight = FontWeight.W800,
    fontSize = 32.sp,
    lineHeight = 45.sp,
    textAlign = TextAlign.Center
)

val buttonStyle = TextStyle(
    fontFamily = epilogueFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 16.sp,
    lineHeight = 16.4.sp
)