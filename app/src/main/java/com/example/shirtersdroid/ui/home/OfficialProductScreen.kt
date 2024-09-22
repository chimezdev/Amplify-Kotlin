package com.example.shirtersdroid.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.ButtonWithImage
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun OfficialProductScreen(
   navController: NavHostController
) {
    ProductDetails(
        onBackPressed = {navController.navigateUp()}
    )
}


@Composable
fun ProductDetails(
    isOfficial: Boolean = true,
    onBackPressed:()->Unit,
) {
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color.White else Color.Black
    val bgColor = if (isDarkMode) Color.Black else Color.White
    var showWishlistMessage by remember {
        mutableStateOf(false)
    }
    var showCartMessage by remember {
        mutableStateOf(true)
    }
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bgColor)
            .verticalScroll(verticalScroll)
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .width(477.51.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.big_polo),
                    contentDescription = "Product Image",
                    modifier = Modifier.fillMaxSize()
                )
                Image(
                    modifier = Modifier
                        .padding(top = 38.dp, start = 10.dp)
                        .size(width = 50.dp, height = 42.dp)
                        .clickable {
                            onBackPressed()
                        },
                    painter = painterResource(id = if (isDarkMode) R.drawable.back_icon_dark else R.drawable.back_icon),
                    contentDescription = "Back arrow"
                )
                Image(
                    painter = painterResource(id = if (showWishlistMessage) R.drawable.black_heart else R.drawable.heart),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 38.dp, end = 45.dp)
                        .zIndex(1f)
                        .clickable {
                            showWishlistMessage = true
                        }
                        .size(35.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.outlined_cart),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 38.dp, end = 6.21.dp)
                        .zIndex(1f)
                        .clickable {
                            showCartMessage = true
                        }
                        .size(32.dp)
                )
                if (showWishlistMessage) {
                    MessageOverlay(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 96.dp, start = 10.dp, end = 10.dp)
                    ) {
                        showWishlistMessage = false
                    }
                }
                if (showCartMessage) {
                    MessageOverlay(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 157.dp, start = 10.dp, end = 10.dp),
                        text = "Item has been added to cart",
                        leadingIcon = if (isDarkMode) R.drawable.active_cart else R.drawable.active_cart
                    ) {
                        showCartMessage = false
                    }
                }

            }
        }

        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Men Roundneck",
                        style = TextStyle(
                            fontFamily = epilogueFontFamily,
                            fontWeight = W800,
                            fontSize = 21.sp,
                            lineHeight = 31.53.sp,
                            color = textColor
                        ),

                        )

                    Column {
                        Text(
                            text = "Posted by",
                            style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontWeight = W400,
                                fontSize = 10.sp,
                                lineHeight = 10.25.sp,
                                color = textColor
                            )
                        )
                        Row {
                            Text(
                                text = "Shirters",
                                style = TextStyle(
                                    fontFamily = epilogueFontFamily,
                                    fontWeight = W800,
                                    fontSize = 15.52.sp,
                                    lineHeight = 19.4.sp,
                                    color = textColor
                                )
                            )
                            Spacer(modifier = Modifier.width(3.03.dp))
                            Image(
                                painter = painterResource(id = R.drawable.verify),
                                contentDescription = "Shirters"
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = "$500",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W800,
                    fontSize = 28.sp,
                    lineHeight = 35.sp,
                    color = textColor
                )
            )
            Spacer(modifier = Modifier.height(25.03.dp))
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Dictum varius pretium, varius et. Sed suspendisse congue quis duis massa magna ac.",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = textColor
                )
            )
            Spacer(modifier = Modifier.height(32.09.dp))
            Text(
                text = "Select Your Size", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 21.sp,
                    lineHeight = 21.53.sp,
                    fontWeight = W800,
                    color = textColor
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val sizes = listOf("XS", "S", "M", "L", "XL")


                    SizeSelector(sizes = sizes, initialSelectedSize = "XS")

            }
            Spacer(modifier = Modifier.height(50.76.dp))

            if (isOfficial) {
                GenericButton(
                    label = "Add to Bag",
                    modifier = Modifier.fillMaxWidth()
                ) {

                }
            } else {
                Row {
                    ButtonWithImage(
                        modifier = Modifier.width(180.dp),
                        label = "Add to Bag",
                        enabled = true,
                        borderColor = textColor,
                        spaceBetween = 20,
                        image = if (isDarkMode) R.drawable.active_cart else R.drawable.black_cart,
                        imageSize = 20
                    ) {

                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    GenericButton(
                        modifier = Modifier.width(180.dp),
                        label = "Buy Now"
                    ) {

                    }
                }
            }


        }
    }
}

@Composable
fun MessageOverlay(
    modifier: Modifier = Modifier,
    text: String = "Item has been added to wishlist",
    leadingIcon: Int = if (isSystemInDarkTheme()) R.drawable.heart else R.drawable.black_heart,
    trailingIcon: Int = if (isSystemInDarkTheme()) R.drawable.black_close else R.drawable.white_close,
    onCloseClicked: () -> Unit,
) {
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color.Black else Color.White
    val bgColor = if (isDarkMode) Color.White else Color.Black
    Row(
        modifier = modifier
            .background(bgColor, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 11.4.dp, horizontal = 22.62.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(28.95.dp),
            painter = painterResource(id = leadingIcon),
            contentDescription = null
        )
        Text(
            text = text,
            style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 14.sp,
                lineHeight = 14.4.sp,
                color = textColor
            )
        )
        Image(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onCloseClicked()
                },
            painter = painterResource(id = trailingIcon),
            contentDescription = null
        )

    }
}

@Preview(device = Devices.NEXUS_5, showBackground = true, showSystemUi = true)
@Composable
fun OfficialProductScreenPreview() {
    ProductDetails(
        onBackPressed = {}
    )
//    MessageOverlay()
}