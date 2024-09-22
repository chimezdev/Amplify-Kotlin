package com.example.shirtersdroid.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun LoadingOverlay(isLoading: Boolean) {
    val isDarkMode = isSystemInDarkTheme()
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if(isDarkMode) Color.Black.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.5f) ),
//                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Dressing",
                    color = if(isDarkMode) Color.Black else Color.White ,
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.W800,
                        lineHeight = 21.53.sp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun LoaderPreview(){
    LoadingOverlay(isLoading = true)
}
