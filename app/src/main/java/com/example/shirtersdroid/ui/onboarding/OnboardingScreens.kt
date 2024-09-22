package com.example.shirtersdroid.ui.onboarding

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.LoadingOverlay
import com.example.shirtersdroid.ui.theme.epilogueFontFamily
import com.example.shirtersdroid.ui.theme.heading2


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun FirstOnboardingScreen(
    onSwipe: () -> Unit,
    onSkip: () -> Unit,
) {
    val isDarkTheme = isSystemInDarkTheme()
    BackHandler(enabled = false) {
        //disallow back button
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectHorizontalDragGestures { change, dragAmount ->
                change.consume()
                if (dragAmount < 0) onSwipe()
            }
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding1),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = FillBounds,
            contentDescription = "Swipe Image"
        )

        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row {
                Spacer(
                    modifier = Modifier
                        .height(6.17.dp)
                        .width(77.36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Black)
                        .padding(20.dp)
                )
                Spacer(modifier = Modifier.width(3.49.dp))
                Spacer(
                    modifier = Modifier
                        .height(6.17.dp)
                        .width(17.2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(20.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .align(Alignment.BottomCenter)
        ) {

            Image(
                painter = painterResource(id = if(isDarkTheme) R.drawable.trap_dark else R.drawable.trap_light),
                contentDescription = "Lower Half Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = FillBounds
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Get The Best\nAffordable Shirts",
                    color = if (isDarkTheme) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    style = heading2,
                )
                Spacer(modifier = Modifier.height(48.dp))
                GenericButton(
                    label = "Swipe to See more",
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {

                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Skip",
                    modifier = Modifier
                        .clickable {
                            onSkip()
                        },
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                        lineHeight = 18.45.sp
                    ),
                    color = if (isDarkTheme) Color.White else Color.Black
                )
            }
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.DEFAULT,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun FirstOnboardingScreenPreview() {
    FirstOnboardingScreen({}, {})
//    SecondOnboardingScreen(
//        onForwardSwipe = {},
//        onBackwardSwipe = {}
//    )
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun SecondOnboardingScreen(
    onForwardSwipe: () -> Unit,
    onBackwardSwipe: () -> Unit,
) {

    val isDarkTheme = isSystemInDarkTheme()
    val isLoading by remember {
        mutableStateOf(false)
    }
    BackHandler(enabled = false) {
        //disallow back button
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding2),
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { change, dragAmount ->
                        change.consume()
                        if (dragAmount > 0) {
                            onBackwardSwipe()
                        } else {
//                            onForwardSwipe()
                        }
                    }
                },
            contentScale = FillBounds,
            contentDescription = "Swipe Image"
        )
        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row {
                Spacer(
                    modifier = Modifier
                        .height(6.17.dp)
                        .width(17.2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(20.dp)
                )

                Spacer(modifier = Modifier.width(3.49.dp))
                Spacer(
                    modifier = Modifier
                        .height(6.17.dp)
                        .width(77.36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Black)
                        .padding(20.dp)
                )
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .align(Alignment.BottomCenter)
        ) {

            Image(
                painter = painterResource(id = if(isDarkTheme) R.drawable.trap_dark else R.drawable.trap_light),
                contentDescription = "Lower Half Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = FillBounds
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "The Best Collection\n" +
                            "of Great Clothes",
                    color = if (isDarkTheme) Color.White else Color.Black,
                    textAlign = TextAlign.Center,
                    style = heading2,
                )
                Spacer(modifier = Modifier.height(48.dp))
                GenericButton(label = "Get Started") {
                    onForwardSwipe()
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Skip",
                    modifier = Modifier.clickable {
                        onForwardSwipe()
                    },
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                        lineHeight = 18.45.sp,
                        textDecoration = TextDecoration.Underline
                    ),
                    color = if (isDarkTheme) Color.White else Color.Black
                )
            }
        }
        LoadingOverlay(isLoading = isLoading)
    }

}