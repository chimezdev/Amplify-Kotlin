package com.example.shirtersdroid.ui.profile.password

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.PasswordField1
import com.example.shirtersdroid.ui.components.SOutlinedButton
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.home.MessageOverlay
import com.example.shirtersdroid.ui.profile.TopBar

@Composable
fun PasswordReset(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var cardNumber by remember { mutableStateOf("") }
    var cardName by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Password Reset",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        PasswordField1(
            modifier = Modifier.fillMaxWidth(),
            label = "Enter Current Password",
            placeHolder = "••••••••••",
            onDone = {},
            onNext = {},
            onValueChange = {
                cardNumber = it
            },
            value = cardNumber
        )

        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add Card",
            onClick = {navHostController.navigate(HomeDirections.PASSWORD_RESET_NEW)}
        )
    }
}

@Composable
fun ConfirmPassword(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var cardNumber by remember { mutableStateOf("") }
    var cardName by remember { mutableStateOf("") }
    var isPasswordUpdated by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Password Reset",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        if (isPasswordUpdated) {
            MessageOverlay(
                leadingIcon = if (isDarkMode) R.drawable.dark_shaded_password_reset else R.drawable.shaded_password_reset,
                text = "Your Password has been updated",
            ) {
                isPasswordUpdated = false
            }
            Spacer(Modifier.height(7.98.dp))
        }
        PasswordField1(
            modifier = Modifier.fillMaxWidth(),
            label = "New Password",
            placeHolder = "••••••••••",
            onDone = {},
            onNext = {},
            onValueChange = {
                cardNumber = it
            },
            value = cardNumber
        )
        Spacer(Modifier.height(32.dp))
        PasswordField1(
            modifier = Modifier.fillMaxWidth(),
            label = "Confirm Password",
            placeHolder = "••••••••••",
            onDone = {},
            onNext = {},
            onValueChange = {
                cardNumber = it
            },
            value = cardNumber
        )
        Spacer(Modifier.height(56.dp))
        SOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Save Password",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun PasswordPreview(){
   ConfirmPassword(rememberNavController())
}