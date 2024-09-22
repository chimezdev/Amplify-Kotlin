package com.example.shirtersdroid.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.CustomSearchBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily
import kotlinx.coroutines.launch

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf("Home", "Design", "Cart", "Profile")
    val (selectedItem, setSelectedItem) = remember { mutableStateOf(items[0]) }
    BottomAppBar(
        contentColor = Color.White,
        contentPadding = PaddingValues(vertical = 5.dp, horizontal = 20.dp),
        containerColor = Color.Black,
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items.forEach { item ->
                    IconButton(
                        onClick = {
                            setSelectedItem(item)
                            navController.navigate(item) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    ) {
                        val iconRes = when (item) {
                            "Home" -> if (selectedItem == "Home") R.drawable.active_home else R.drawable.home
                            "Design" -> if (selectedItem == "Design") R.drawable.active_design else R.drawable.design
                            "Cart" -> if (selectedItem == "Cart") R.drawable.active_cart else R.drawable.cart
                            "Profile" -> if (selectedItem == "Profile") R.drawable.active_profile else R.drawable.profile
                            else -> R.drawable.home
                        }
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = item,
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun LandingScreen(
    navController: NavHostController,
) {
    LandingScreenContent(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreenContent(
    navController: NavHostController,
) {
    val isDark = isSystemInDarkTheme()
    val textColor = if (isDark) Color.White else Color.Black
    val sheetState = rememberModalBottomSheetState(true)
    val coroutineScope = rememberCoroutineScope()
    var showFilter by remember {
        mutableStateOf(false)
    }
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = if (isDark) Color.Black else Color(0xFFF2F2F2)
                )
                .padding(top = 40.dp, start = 16.dp, end = 10.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 23.72.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Hello John", style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 24.sp,
                                lineHeight = 24.6.sp,
                                fontWeight = W800,
                                color = textColor
                            )
                        )
                        Spacer(modifier = Modifier.height(7.92.dp))
                        Text(
                            text = "Get your dress very easily", style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontWeight = W400,
                                color = textColor
                            ), color = textColor
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Box(
                            modifier = Modifier,
                            contentAlignment = Alignment.Center
                        ) {
                            Canvas(modifier = Modifier.size(31.81.dp), onDraw = {
                                drawCircle(color = Color.White)
                            })
                            Image(
                                painter = painterResource(id = R.drawable.notification_icon),
                                contentDescription = "Notification Icon",
                                modifier = Modifier.clickable {
                                    navController.navigate(HomeDirections.NOTIFICATIONS)
                                }
                            )
                        }
                        Spacer(modifier = Modifier.width(6.4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.profile_icon),
                            contentDescription = "Profile Icon",
                            modifier = Modifier.size(43.dp)
                        )
                    }


                }

            }

            item {
                CustomSearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 34.45.dp),
                    placeHolder = "Search for collections and clothes...",
                    value = "",
                    onValueChange = {},
                    onFilterClicked = {
                        showFilter = true
                    },
                    onSearchClicked = {}
                )
            }
            item {
                Column {
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "New Arrival", style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 21.sp,
                                lineHeight = 21.53.sp,
                                fontWeight = W800,
                                color = textColor
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "See All",
                            textDecoration = TextDecoration.Underline,
                            style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 14.sp,
                                lineHeight = 14.34.sp,
                                fontWeight = W400,
                                color = textColor
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.landing_img),
                            contentDescription = "Landing screen image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentScale = ContentScale.FillBounds
                        )

                        Row(
                            modifier = Modifier.padding(
                                bottom = 21.dp,
                                end = 9.27.dp,
                                start = 16.dp
                            ),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Column {
                                Text(
                                    text = "Blue Skim Shirt", style = TextStyle(
                                        fontFamily = epilogueFontFamily,
                                        fontWeight = W600,
                                        fontSize = 18.sp,
                                        lineHeight = 18.45.sp,
                                        color = Color.White
                                    )
                                )
                                Text(
                                    text = "By Raddo Fashion", style = TextStyle(
                                        fontFamily = epilogueFontFamily,
                                        fontWeight = W400,
                                        fontSize = 10.sp,
                                        lineHeight = 10.25.sp,
                                        color = Color.White
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFC4C4C4),
                                        shape = RectangleShape
                                    )
                                    .padding(vertical = 13.62.dp, horizontal = 11.33.dp)
                            ) {
                                Row(verticalAlignment = Alignment.Top) {
                                    Text(
                                        text = "Explore All",
                                        color = Color.White,
                                        style = TextStyle(
                                            fontFamily = epilogueFontFamily,
                                            fontSize = 12.sp,
                                            lineHeight = 12.3.sp,
                                            fontWeight = W400,
                                            color = Color.White
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.72.dp))
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                        contentDescription = "Explore All Arrow",
                                        tint = Color.White,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }

                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(44.45.dp))
            }
            item {
                Column {
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Top Collections", style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 21.sp,
                                lineHeight = 21.53.sp,
                                fontWeight = W800,
                                color = textColor
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "See All",
                            textDecoration = TextDecoration.Underline,
                            style = TextStyle(
                                fontFamily = epilogueFontFamily,
                                fontSize = 14.sp,
                                lineHeight = 14.34.sp,
                                fontWeight = W400,
                                color = textColor
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CircularImage(
                        image = R.drawable.tshirt,
                        text = "T-Shirt",
                        textColor = textColor
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    CircularImage(
                        image = R.drawable.polo,
                        text = "Polo",
                        textColor = textColor
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    CircularImage(
                        image = R.drawable.vest,
                        text = "Vest",
                        textColor = textColor
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    CircularImage(
                        image = R.drawable.hoodie,
                        text = "Hoodie",
                        textColor = textColor
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        DisplayCard(
                            desc = "Men Roundneck Shirt",
                            price = "$500",
                            image = R.drawable.big_polo,
                            onCardClick = {
                                navController.navigate(HomeDirections.PRODUCT_DETAIL)
                            }) {

                        }
                    }
                    item {
                        DisplayCard(
                            desc = "Orange Man Hoodie",
                            price = "$500",
                            image = R.drawable.men_hoodie,
                            onCardClick = {
                                navController.navigate(HomeDirections.PRODUCT_DETAIL)
                            }) {

                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

            }
            item {
                Text(
                    text = "Most Purchased", style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 21.sp,
                        lineHeight = 21.53.sp,
                        fontWeight = W800,
                        color = textColor
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                MostPurchasedCard(
                    desc = "Men Roundneck Shirt",
                    price = "$500",
                    image = R.drawable.big_polo,
                    onIconClick = {},
                    onCardClick = {}
                )
                Spacer(modifier = Modifier.height(16.dp))
                MostPurchasedCard(
                    desc = "Men Roundneck Shirt",
                    price = "$500",
                    image = R.drawable.big_polo,
                    onIconClick = {},
                    onCardClick = {}
                )
            }
        }
    if (showFilter){
        ModalBottomSheet(
            onDismissRequest = {

            },
            sheetState = sheetState,
            dragHandle = {BottomSheetDefaults.DragHandle()},
            content = {
                Filter(
                    onBackClicked = {
                        coroutineScope.launch{
                            showFilter = false
                        }

                    },
                    onCloseClicked = {
                        coroutineScope.launch{
                            showFilter = false
                        }
                    }
                )
            }
        )
    }

    }

}

@Composable
fun MostPurchasedCard(
    desc: String,
    vendor: String = "By Super Shirts",
    price: String,
    image: Int,
    onCardClick: () -> Unit,
    onIconClick: () -> Unit,
) {
    val isDark = isSystemInDarkTheme()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isDark) Color(0xFF333333) else Color.White)
            .padding(7.dp)
    ) {
        Row {
            Box(){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 107.34.dp, height = 104.97.dp)
                        .clickable {
                            onCardClick()
                        },
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 3.88.dp, end = 5.72.dp)
                        .zIndex(1f)
                        .clickable {
                            onIconClick()
                        }
                )
            }

        }
        Spacer(modifier = Modifier.width(16.48.dp))
        Column {
            Spacer(modifier = Modifier.height(12.09.dp))
            Text(
                text = desc, style = TextStyle(
                    fontWeight = W400,
                    fontFamily = epilogueFontFamily,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = if (isDark) Color.White else Color.Black
                )
            )
            Spacer(modifier = Modifier.height(6.07.dp))
            Text(
                text = price, style = TextStyle(
                    fontWeight = W600,
                    fontFamily = epilogueFontFamily,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = if (isDark) Color.White else Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.81.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.by_shirters),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.8.dp)
                        .clickable {
                            onCardClick()
                        },
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(6.07.dp))
                Text(
                    text = vendor, style = TextStyle(
                        fontWeight = W400,
                        fontFamily = epilogueFontFamily,
                        fontSize = 10.sp,
                        lineHeight = 10.25.sp,
                        color = if (isDark) Color.White else Color.Black
                    )
                )
            }
        }
    }
}

@Composable
fun DisplayCard(
    desc: String,
    price: String,
    image: Int,
    onCardClick: () -> Unit,
    onIconClick: () -> Unit,
) {
    val isDark = isSystemInDarkTheme()
    Column(
        modifier = Modifier
            .width(182.dp)
            .height(218.71.dp)
            .background(color = if (isDark) Color(0xFF333333) else Color.White)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 4.4.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 164.3.dp, height = 160.67.dp)
                    .clickable {
                        onCardClick()
                    },
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Favorite Icon",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 3.88.dp, end = 5.72.dp)
                    .zIndex(1f)
                    .clickable {
                        onIconClick()
                    }
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = desc, style = TextStyle(
                fontWeight = W400,
                fontFamily = epilogueFontFamily,
                fontSize = 12.sp,
                lineHeight = 12.3.sp,
                color = if (isDark) Color.White else Color.Black
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = price, style = TextStyle(
                fontWeight = W600,
                fontFamily = epilogueFontFamily,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = if (isDark) Color.White else Color.Black
            )
        )
    }
}

@Composable
fun CircularImage(
    image: Int,
    text: String,
    textColor: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(0.dp, Color.Gray, CircleShape)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Circular Image",
                modifier = Modifier.fillMaxSize()
            )

        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text, style = TextStyle(
                fontWeight = W400,
                fontFamily = epilogueFontFamily,
                fontSize = 12.sp,
                lineHeight = 12.3.sp
            ),
            color = textColor
        )
    }

}

@Preview(showBackground = true, showSystemUi = true, device = Devices.DESKTOP)
@Composable
fun ContentPreview() {
    LandingScreenContent(rememberNavController())
//    BottomNavBar(navController = rememberNavController())
}