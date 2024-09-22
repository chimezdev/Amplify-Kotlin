package com.example.shirtersdroid.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun NotificationScreen(
    navHostController: NavHostController
) {
    NotificationContent(notification = listOf("k","l")) {
        navHostController.navigateUp()
    }
}


@Composable
fun NotificationContent(
    notification: List<String>,
    goHome: () -> Unit,
) {
    val isDarkMode = isSystemInDarkTheme()
    val bgColor = if (isDarkMode) Color.Black else Color(0xFFE7EAEE)
    val textColor = if (isDarkMode) Color.White else Color.Black
    if (notification.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sorry Your Notification is empty", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    color = Color(0xFF666666)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.clickable {
                    goHome()
                },
                text = "Start a Purchase", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    color = textColor,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = bgColor)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier.size(width = 39.91.dp, 33.52.dp).clickable { goHome() },
                    painter = painterResource(id = if (isDarkMode) R.drawable.back_icon_dark else R.drawable.back_icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(77.59.dp))
                Text(
                    text = "Notification", style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W600,
                        fontSize = 24.sp,
                        lineHeight = 28.sp,
                        color = textColor
                    )
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                NotificationItem()
                NotificationItem()
                NotificationItem()
            }
        }
    }

}

@Composable
fun NotificationItem(
    image:Int = R.drawable.men_hoodie,
    title:String = "Your Order is on the way",
    description:String="Your Order is on the way",
) {
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color.White else Color.Black
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isDarkMode) Color(0xFF333333) else Color.White)
            .padding(horizontal = 13.14.dp, vertical = 9.26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(40.69.dp)
                .clip(CircleShape),
            painter = painterResource(id = image),
            contentDescription = null
        )
        Column {
            Text(text = title, style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = textColor
            ))
            Spacer(modifier = Modifier.height(3.19.dp))
            if (description.isNotEmpty()){
                Text(text = description, style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 12.sp,
                    lineHeight = 12.3.sp,
                    color = textColor
                ))
            }

        }
        Image(
            modifier = Modifier
                .size(25.81.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.nnotification_close),
            contentDescription = null
        )
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NotificationPreview() {
    NotificationContent(
        notification = listOf("ggg", "njjj"),
        goHome = {}
    )
}