package com.example.shirtersdroid.ui.profile.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.ui.components.ButtonWithImage
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.SOutlinedButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun EditCreditCard(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var cardNumber by remember { mutableStateOf("") }
    var cardName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Edit Credit Card",
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
            label = "Save Changes",
            onClick = {}
        )
        Spacer(Modifier.height(56.dp))
        Text(
            text = "Delete Credit Card", style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 14.sp,
                lineHeight = 14.35.sp,
                color = if(isDarkMode) Color.White else Color.Black,
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .clickable {
                showDialog = true
            }
        )

        if (showDialog) {
            Dialog(
                onDismissRequest = { showDialog = false },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ){
                Column(
                    modifier = Modifier.background(if (isDarkMode) Color.Black else Color.White)
                        .padding(40.dp)
                ) {
                    Text(
                        "Are you Sure you want to  Delete this credit card?",
                        style = TextStyle(
                            fontFamily = epilogueFontFamily,
                            fontSize = 24.sp,
                            fontWeight = W600,
                            lineHeight = 32.sp,
                            color = if(isDarkMode) Color.White else Color.Black
                        )
                    )
                    Spacer(Modifier.height(31.17.dp))
                    GenericButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Delete",
                        onClick = {
                            showDialog = false
                        }
                    )
                    Spacer(Modifier.height(31.17.dp))
                    SOutlinedButton(
                        modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                        label = "Cancel",
                        enabled = true,
                        onClick = {
                            showDialog = false
                        }
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun EditCreditCardPreview(){
    EditCreditCard(rememberNavController())
}