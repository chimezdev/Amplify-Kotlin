package com.example.shirtersdroid.ui.profile.report

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.profile.TopBar

@Composable
fun Report(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Reports",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        TextField1(
            label = "Title",
            placeHolder = "",
            onDone = {},
            onNext = {},
            onValueChange = {
                title = it
            },
            value = title
        )

        Spacer(Modifier.height(32.dp))
        TextField1(
            modifier = Modifier.heightIn(min = 120.dp),
            label = "Message",
            placeHolder = "",
            onDone = {},
            onNext = {},
            onValueChange = {
                message = it
            },
            value = message,
        )
        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Report",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ReportPreview(){
    Report(rememberNavController())
}