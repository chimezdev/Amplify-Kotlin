package com.example.shirtersdroid.ui.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.ButtonWithImage
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.PasswordField1
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.theme.epilogueFontFamily
import com.example.shirtersdroid.ui.theme.heading1

@Composable
fun LoginScreen(
    gotoForgotPassword:()->Unit,
    gotoCreateAccount:()->Unit,
    proceedToHome:()->Unit,
) {
    val isDark = isSystemInDarkTheme()
    val textColor = if (isDark) Color.White else Color.Black
    val viewModel: LoginViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    BackHandler(enabled = false) {
        //disallow back button
    }

    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = if (isDark) Color.Black else Color(0xFFF2F2F2)
            )
            .padding(top = 86.36.dp, start = 24.dp, end = 24.dp)
            .verticalScroll(scrollableState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shirters",
            style = heading1,
            color = textColor
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Log in to your account", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontSize = 21.sp,
                lineHeight = 21.53.sp,
                fontWeight = W600,
                color = textColor
            )
        )
        Spacer(modifier = Modifier.height(64.dp))
        ButtonWithImage(
            label = "Login with Google",
            image = R.drawable.google_icon,
            enabled = true
        ) {

        }
        Spacer(modifier = Modifier.height(64.dp))
        TextField1(
            modifier = Modifier.fillMaxWidth(),
            label = "Email Address",
            placeHolder = "xxx@example.com",
            value = uiState.email,
            onValueChange = {
                viewModel.updateEmail(it)
            },
            onDone = { /*TODO*/ }) {

        }
        Spacer(modifier = Modifier.height(32.dp))
        PasswordField1(
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            placeHolder = "••••••••••••••",
            value = uiState.password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            onNext = {}
        ) {

        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Forgot Password",
            style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = if(isDark) Color.White else Color.Black,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier.clickable {
                gotoForgotPassword()
            }
        )
        Spacer(modifier = Modifier.height(93.97.dp))
        GenericButton(
            label = "Login",
            modifier = Modifier.fillMaxWidth()
            ) {
            proceedToHome()
        }
        Spacer(modifier = Modifier.height(16.dp))
        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                color = if(isDark) Color.White else Color.Black,
            )){
                append(text = "Don’t Have an Account, ")
            }
            withStyle(style = SpanStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W800,
                fontSize = 18.sp,
                color = if(isDark) Color.White else Color.Black,
                textDecoration = TextDecoration.Underline
            )){
                append(text = "Create Account")
                addStringAnnotation("create","", start = 1, end = 2)
            }
        }
        ClickableText(
            text = text,
            style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = if(isDark) Color.White else Color.Black,
            ),
            onClick = {offset->
                text.getStringAnnotations(start = offset, end = offset, tag = "create").firstOrNull().let {
                    gotoCreateAccount()
                }
            }
        )
        Spacer(modifier = Modifier.height(77.dp))
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen(
        gotoCreateAccount = {},
        gotoForgotPassword = {},
        proceedToHome = {}
    )
}