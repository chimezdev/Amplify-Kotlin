package com.example.shirtersdroid.ui.profile.seller

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight.Companion.W800
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
fun BecomeSeller(
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    var shopName by remember { mutableStateOf("") }
    var bannerImageUri by remember { mutableStateOf<Uri?>(null) }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    // Launchers for picking images
    val bannerImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            bannerImageUri = uri
        }
    )

    val profileImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            profileImageUri = uri
        }
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Become a Seller",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(54.26.dp))
        Text(
            text = "Setup your Shop", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(44.5.dp))
        Text(
            text = "Add a Cover Photo", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W800,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(24.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxWidth().height(112.dp),
                painter = painterResource(R.drawable.shop_banner_placeholder),
                contentDescription = "Shop Banner",
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier.size(32.dp).clickable {
                    bannerImageLauncher.launch("image/*")
                },
                painter = painterResource(R.drawable.upload_picture),
                contentDescription = "Shop Banner",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Shop Profile Pics", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W800,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(24.dp))
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                modifier = Modifier.size(93.dp).border(
                    width = 0.dp, color = Color.White, shape = CircleShape
                ),
                painter = painterResource(R.drawable.profile_image_placeholder),
                contentDescription = "Shop Profile Pics",
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier.size(22.38.dp).clickable {
                    profileImageLauncher.launch("image/*")
                },
                painter = painterResource(R.drawable.upload_picture),
                contentDescription = "Shop Banner",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(Modifier.height(40.91.dp))
        TextField1(
            label = "Shop Name",
            placeHolder = "John Doe",
            onDone = {},
            onNext = {},
            value = shopName,
            onValueChange = { shopName = it }
        )
        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Set up Shop"
        ) {
            navHostController.navigate(HomeDirections.SELLER_SUCCESS)
        }
    }
}

@Composable
fun SuccessfulShopSetup(
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            title = "Become a Seller",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(77.5.dp))
        Text(
            text = "Congratulations", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(34.17.dp))
        Image(
            painter = painterResource(R.drawable.check_circle),
            contentDescription = "Congratulations"
        )
        Spacer(Modifier.height(62.65.dp))
        Text(
            text = "Your shop has been sucessfully created. ", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Go to Shop"
        ) {

        }
    }
}

@Preview
@Composable
fun BecomeSellerPreview() {
    SuccessfulShopSetup(rememberNavController())
}