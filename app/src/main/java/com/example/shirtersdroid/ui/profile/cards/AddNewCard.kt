package com.example.shirtersdroid.ui.profile.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun AddNewCreditCard(
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
            title = "Add New Card",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        TextField1(
            label = "Card Number",
            placeHolder = "XXXX-XXXX-XXXX",
            onDone = {},
            onNext = {},
            onValueChange = {
                cardNumber = it
            },
            value = cardNumber
        )

        Spacer(Modifier.height(32.dp))

        TextField1(
            label = "Card Name",
            placeHolder = "John Doe",
            onDone = {},
            onNext = {},
            onValueChange = {
                cardName = it
            },
            value = cardName
        )

        Spacer(Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField1(
                modifier = Modifier.width(180.86.dp),
                label = "Exp Date",
                placeHolder = "MM/YY",
                onDone = {},
                onNext = {},
                onValueChange = {
                    cardNumber = it
                },
                value = cardNumber
            )
            Spacer(Modifier.width(16.14.dp))
            TextField1(
                modifier = Modifier.width(180.86.dp),
                label = "CVV",
                placeHolder = "123",
                onDone = {},
                onNext = {},
                onValueChange = {
                    cardNumber = it
                },
                value = cardNumber
            )
        }
       
        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add Card",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun AddCardPreview(){
    AddNewCreditCard(rememberNavController())
}