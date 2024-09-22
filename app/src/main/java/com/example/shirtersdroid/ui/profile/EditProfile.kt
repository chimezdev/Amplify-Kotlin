package com.example.shirtersdroid.ui.profile

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.home.MessageOverlay
import com.example.shirtersdroid.ui.theme.Typography
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun EditProfile(
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color.White else Color.Black
    val username by remember { mutableStateOf("") }
    val isProfileSaved by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            title = "Edit Profile",
            onBackPressed = {
                navHostController.navigateUp()
            }
        )
        Spacer(Modifier.height(46.5.dp))
        if (isProfileSaved) {
            MessageOverlay(
                leadingIcon = R.drawable.alert_icon,
                text = "Your Profile Has been updated",
            ) {

            }
        }
        DisplayProfilePicture()
        Spacer(Modifier.height(8.83.dp))
        TextField1(
            label = "Username",
            onNext = {},
            onDone = {},
            onValueChange = {},
            value = username,
            placeHolder = "John Doe",

            )
        Spacer(Modifier.height(32.dp))
        TextField1(
            label = "Email Address",
            onNext = {},
            onDone = {},
            onValueChange = {},
            value = username,
            placeHolder = "johndoe@gmail.com",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(Modifier.height(56.dp))
        GenericButton(
            enabled = false,
            label = "Save Changes",
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}

@Composable
fun DisplayProfilePicture() {
    Box(
        modifier = Modifier.background(Color(0xFFFFB376), CircleShape).size(92.7.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            modifier = Modifier.size(92.23.dp),
            painter = painterResource(R.drawable.placeholder_image),
            contentDescription = "Profile Picture"
        )
        Image(
            modifier = Modifier.size(22.38.dp).border(4.dp, Color(0xFFF2F2F2), CircleShape),
            painter = painterResource(if (isSystemInDarkTheme()) R.drawable.dark_upload_picture else R.drawable.upload_picture),
            contentDescription = "Upload Profile Picture"
        )

    }
}

@Composable
fun TopBar(
    title: String,
    onBackPressed: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(50.59.dp)
    ) {
        Image(
            painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.back_icon_dark else R.drawable.back_icon),
            contentDescription = null,
            modifier = Modifier.size(width = 39.91.dp, height = 33.52.dp)
                .clickable { onBackPressed() }
        )
        Text(
            text = title, style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 24.sp,
                lineHeight = 28.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
    }
}


@Preview
@Composable
fun EditProfilePreview() {
    EditProfile(navHostController = rememberNavController())
}