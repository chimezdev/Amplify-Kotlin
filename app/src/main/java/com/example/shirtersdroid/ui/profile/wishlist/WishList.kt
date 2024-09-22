package com.example.shirtersdroid.ui.profile.wishlist

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun WishList(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var isGridView by remember { mutableStateOf(false) }
    val items = listOf(
        Triple("Men Roundneck Shirt", "$500", R.drawable.men_hoodie),
        Triple("Women's Blouse", "$450", R.drawable.men_hoodie),
        Triple("Kids T-Shirt", "$300", R.drawable.men_hoodie),
        Triple("Unisex Sweater", "$600", R.drawable.men_hoodie)
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Wishlist",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(43.5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "6 items in your wishlist", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp
                )
            )
            ViewSelector(isGridView, onViewChange = {isGridView = it})
        }
        Spacer(Modifier.height(16.dp))
        if (isGridView) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) { item ->
                    GridDisplayCard(desc = item.first, price = item.second, image = item.third)
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items) { item ->
                    ListDisplayCard(desc = item.first, price = item.second, image = item.third)
                }
            }
        }
    }

}

@Composable
fun ViewSelector(
    isGridView: Boolean,
    onViewChange: (Boolean) -> Unit
) {
    val isDarkMode = isSystemInDarkTheme()
    val listImage = when{
        isDarkMode && !isGridView -> R.drawable.dark_active_list
        !isDarkMode && !isGridView -> R.drawable.dark_list
        !isDarkMode && isGridView -> R.drawable.list
        isDarkMode && isGridView -> R.drawable.active_list
        else -> R.drawable.list
    }
    val gridImage = when{
        !isDarkMode && isGridView -> R.drawable.active_grid
        isDarkMode && isGridView -> R.drawable.dark_active_grid
        isDarkMode && !isGridView -> R.drawable.dark_grid
        !isDarkMode && !isGridView -> R.drawable.grid
        else -> R.drawable.grid
    }
    Row(
        modifier = Modifier.background(color = if (isDarkMode) Color(0xFF999999) else Color.White)
            .padding(2.3.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(gridImage),
            contentDescription = "Grid View",
            modifier = Modifier
                .clickable { onViewChange(true) }
                .padding(8.dp),
        )
        Icon(
            painter = painterResource(listImage),
            contentDescription = "List View",
            modifier = Modifier
                .clickable { onViewChange(false) }
                .padding(8.dp),
            tint = if (!isGridView) Color.Black else Color.Gray
        )
    }
}

@Composable
fun GridDisplayCard(
    desc: String,
    price: String,
    image: Int,
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
                ,
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.black_heart),
                contentDescription = "Favorite Icon",
                modifier = Modifier
                    .size(28.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 3.88.dp, end = 5.72.dp)
                    .zIndex(1f)
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
fun ListDisplayCard(
    desc: String,
    price: String,
    image: Int,
){
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
                        ,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(id = R.drawable.black_heart),
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .size(28.dp)
                        .align(Alignment.TopEnd)
                        .padding(top = 3.88.dp, end = 5.72.dp)
                        .zIndex(1f)

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

                        ,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(6.07.dp))
                Text(
                    text = "By Super Shirts", style = TextStyle(
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

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun WishListPreview(){
    WishList(rememberNavController())
}