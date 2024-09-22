package com.example.shirtersdroid.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.home.CheckOutDirections
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun Cart(navHostController: NavHostController) {
    val isDarkMode = isSystemInDarkTheme()
    val backgroundColor = if (isDarkMode) Color.Black else Color(0xFFF2F2F2)
    val cartItems: List<CartItem> = listOf(
        CartItem(desc = "Men Roundneck Shirt", price = "\$200", image = R.drawable.men_hoodie)
    )
    val keyboard = LocalSoftwareKeyboardController.current
    var couponCode by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Carts",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(43.5.dp))
        cartItems.forEach { item ->
            CartItem(item)
            Spacer(Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = couponCode,
                onValueChange = {

                    couponCode = it
                },
                enabled = true,
                placeholder = {
                    Text(
                        text = "Coupon Code", style = TextStyle(
                            fontFamily = epilogueFontFamily,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                            lineHeight = 18.45.sp
                        ), color = if (isDarkMode) Color(0xFFC2C2C2) else Color.Black
                    )
                },
                maxLines = 1,
                minLines = 1,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = if (isDarkMode) Color.White else Color.Black,
                    disabledTextColor = Color.DarkGray,
                    focusedBorderColor = Color(0xFFB8C0CC),
                    unfocusedBorderColor = Color(0xFFB8C0CC),
                    errorBorderColor = Color.Red,
                    errorContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
                    focusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
                    unfocusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
//                focusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
//                unfocusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
                ),
                shape = RectangleShape,
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions(onDone = {
                    keyboard?.hide()
                }, onNext = {
                    keyboard?.hide()
                }),
                trailingIcon = {
                    Row(Modifier.requiredHeight(51.dp)
                        .background(if (isDarkMode)Color.White else Color.Black)
                        .padding(vertical = 15.dp, horizontal = 10.dp)) {
                        Text(
                            text = "Apply",
                            style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 16.4.sp,
                                color = if (isDarkMode) Color.Black else Color.White
                            )
                        )
                    }
                }
            )

        }

        Spacer(Modifier.height(49.38.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Est. Total",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
            Text(
                text = "\$400",
                style = TextStyle(
                    fontWeight = FontWeight.W600,
                    fontFamily = epilogueFontFamily,
                    fontSize = 28.sp,
                    lineHeight = 28.7.sp,
                    color = if (isDarkMode) Color.White else Color.Black
                )
            )
        }
        Spacer(Modifier.height(31.05.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Proceed to Checkout",
            onClick = {
                navHostController.navigate(CheckOutDirections.CHECKOUT)
            }
        )
    }
}

@Composable
fun CartItem(item: CartItem) {
    val isDark = isSystemInDarkTheme()
    var count by remember { mutableStateOf(item.quantity) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isDark) Color(0xFF333333) else Color.White)
            .padding(7.dp)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.size(width = 107.34.dp, height = 104.97.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.48.dp))

        Column {
            CartItemDetails(item, isDark)
            Spacer(modifier = Modifier.height(10.81.dp))
            CartItemActions(
                count = count,
                onDecrement = { if (count > 1) count-- },
                onIncrement = { count++ },
                onDelete = { /* Implement delete functionality */ },
                isDark = isDark
            )
        }
    }
}

@Composable
fun CartItemDetails(item: CartItem, isDark: Boolean) {
    val textColor = if (isDark) Color.White else Color.Black

    Text(
        text = item.desc,
        style = TextStyle(
            fontWeight = FontWeight.W400,
            fontFamily = epilogueFontFamily,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = textColor
        )
    )
    Spacer(modifier = Modifier.height(6.07.dp))
    Text(
        text = item.price,
        style = TextStyle(
            fontWeight = FontWeight.W600,
            fontFamily = epilogueFontFamily,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = textColor
        )
    )
}

@Composable
fun CartItemActions(
    count: Int,
    onDecrement: () -> Unit,
    onIncrement: () -> Unit,
    onDelete: () -> Unit,
    isDark: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuantityButton(R.drawable.minus_icon, "Minus", onDecrement)
            Text(
                text = count.toString(),
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    lineHeight = 18.45.sp
                )
            )
            QuantityButton(
                if (isDark) R.drawable.dark_plus_icon else R.drawable.plus_icon,
                "Add",
                onIncrement
            )
        }
        QuantityButton(R.drawable.delete, "Delete", onDelete)
    }
}

@Composable
fun QuantityButton(iconRes: Int, contentDescription: String, onClick: () -> Unit) {
    Image(
        painter = painterResource(iconRes),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(29.4.dp)
            .clickable(onClick = onClick)
    )
}

@Preview
@Composable
fun CartPreview() {
    Cart(rememberNavController())
}

data class CartItem(
    val desc: String,
    val price: String,
    val image: Int,
    val quantity: Int = 1
)