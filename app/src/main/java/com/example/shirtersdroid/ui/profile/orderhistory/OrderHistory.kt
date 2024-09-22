package com.example.shirtersdroid.ui.profile.orderhistory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun OrderHistory(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Order History",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(43.5.dp))
        OrderItem()
    }
}

@Composable
fun OrderItem(
    onClick:() -> Unit = {},
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if(isDarkMode) Color.White else Color.Black
    Row(
        modifier = Modifier.fillMaxWidth().height(120.86.dp).background(color = if (isDarkMode)Color.Black else Color.White).padding(11.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.width(90.dp),
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ){
                Image(
                    modifier = Modifier.height(58.1.dp).width(60.12.dp),
                    painter = painterResource(R.drawable.men_hoodie),
                    contentDescription = "",
                )
                Image(
                    painter = painterResource(R.drawable.men_hoodie),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd,
                    modifier = Modifier.height(58.1.dp).width(60.12.dp)
                        .offset(x = 30.dp, y = 30.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Order Status",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 12.sp,
                    lineHeight = 12.3.sp,
                    textAlign = TextAlign.Center,
                    color = textColor
                )
            )
            Spacer(Modifier.height(6.06.dp))
            Text(
                "Delivered on",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 10.sp,
                    lineHeight = 10.25.sp,
                    textAlign = TextAlign.Center,
                    color = if (isDarkMode) Color.Black else Color.White
                ),
                modifier = Modifier
                    .background(color = if (isDarkMode) Color.White else Color.Black, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
            Spacer(Modifier.height(11.84.dp))
            Text(
                "12/02/2022",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 10.sp,
                    lineHeight = 10.25.sp,
                    textAlign = TextAlign.Center,
                    color = textColor
                ),
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(if (isDarkMode) R.drawable.black_arrow_right else R.drawable.white_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(24.dp).clickable {
                    onClick()
                    navHostController.navigate(HomeDirections.ORDER_HISTORY_SUMMARY)
                }
            )
        }
    }
}

@Preview
@Composable
fun OrderHistoryPreview(){
    OrderHistory(rememberNavController())
}