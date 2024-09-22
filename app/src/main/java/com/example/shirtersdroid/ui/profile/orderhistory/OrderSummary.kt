package com.example.shirtersdroid.ui.profile.orderhistory

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.profile.cards.CreditCard
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun OrderSummary(
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Order Summary",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(43.5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Order Name", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )

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
                    .background(
                        color = if (isDarkMode) Color.White else Color.Black,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Order #30011", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )

            Text(
                text = "12/02/2022", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
        }
        Spacer(Modifier.height(32.dp))
        OrderItem()
        Spacer(Modifier.height(32.dp))
        Text(
            text = "Shipping Method", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 25.sp,
                lineHeight = 25.53.sp,
                color = if (isDarkMode) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Pick from store", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = if (isDarkMode) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text = "Shipping Address", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 25.sp,
                lineHeight = 25.53.sp,
                color = if (isDarkMode) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "John Doe\n" +
                    "Apartment 2c\n" +
                    "2715 Ash Dr. San Jose, South Dakota 83475\n" +
                    "USA", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = if (isDarkMode) Color.White else Color.Black
            )
        )

        Spacer(Modifier.height(32.dp))
        Text(
            text = "Payment Method", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 25.sp,
                lineHeight = 25.53.sp,
                color = if (isDarkMode) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(16.dp))
       CustomerCard(
           R.drawable.master_card,
           name = "John Doe",
           cardNumber = "2345-2233-2334-221",
           expDate = "12/24"
       )
        Spacer(Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Products", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Text(
                text = "$400", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 18.sp,
                    lineHeight = 18.45.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Shipping Fee", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Text(
                text = "$400", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 18.sp,
                    lineHeight = 18.45.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
        }
        Spacer(Modifier.height(20.43.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Est. Total", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Text(
                text = "$400", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 28.sp,
                    lineHeight = 28.7.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
        }
    }


}

@Composable
fun CustomerCard(
    image: Int?,
    name: String,
    cardNumber: String,
    expDate: String,
) {
    val isDarkMode = isSystemInDarkTheme()
    val textStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontWeight = W400,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        color = if (isDarkMode) Color.White else Color.Black
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isDarkMode) Color(0xFF333333) else Color.White)
            .padding(16.dp),
    ) {
        Row {
            image?.let { painterResource(it) }?.let {
                Image(
                    painter = it,
                    contentDescription = null
                )
            }
        }
        Spacer(Modifier.width(29.37.dp))
        Row {
            Column {
                Text(text = name, style = textStyle)
                Spacer(Modifier.height(2.dp))
                Text(text = cardNumber, style = textStyle)
                Spacer(Modifier.height(2.dp))
                Text(text = expDate, style = textStyle)
            }
        }

    }
}

@Composable
fun OrderItem() {
    val isDarkMode = isSystemInDarkTheme()
    Row(
        modifier = Modifier,

        ) {
        Image(
            modifier = Modifier.size(width = 120.04.dp, height = 116.dp),
            painter = painterResource(R.drawable.men_hoodie),
            contentDescription = "",
        )
        Spacer(Modifier.width(15.25.dp))
        Column {
            Text(
                text = "Men Roundneck Shirt", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Spacer(Modifier.height(10.22.dp))
            Text(
                text = "\$200", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Spacer(Modifier.height(6.28.dp))
            Row {
                Text(
                    text = "Quantity: 2", style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W400,
                        fontSize = 14.sp,
                        lineHeight = 14.35.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
                Spacer(Modifier.width(14.07.dp))
                Text(
                    text = "Size: XL", style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W400,
                        fontSize = 14.sp,
                        lineHeight = 14.35.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun OrderSummaryPreview() {
    OrderSummary(rememberNavController())
}
