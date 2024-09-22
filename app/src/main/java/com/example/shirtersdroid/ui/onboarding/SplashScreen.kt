package com.example.shirtersdroid.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shirtersdroid.ui.theme.heading1
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToNextScreen:()->Unit
)
{
    LaunchedEffect(Unit) {
        delay(1000)
        navigateToNextScreen()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Shirters", style = heading1)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen({})
}

