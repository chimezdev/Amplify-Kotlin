package com.example.shirtersdroid.ui.cart

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.profile.cards.CreditCard
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun EditCard(
    navHostController: NavHostController,
    creditCard: CreditCard,
    onDone:()->Unit,
){
    val isDarkMode = isSystemInDarkTheme()
    var isChecked by remember { mutableStateOf(false) }


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
//                creditCard.cardNumber = it
            },
            value = creditCard.cardNumber
        )

        Spacer(Modifier.height(32.dp))

        TextField1(
            label = "Card Name",
            placeHolder = "John Doe",
            onDone = {},
            onNext = {},
            onValueChange = {
                //creditCard.cardNumber = it
            },
            value = creditCard.cardNumber
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
                    //creditCard.expDate = it
                },
                value = creditCard.expDate
            )
            Spacer(Modifier.width(16.14.dp))
            TextField1(
                modifier = Modifier.width(180.86.dp),
                label = "CVV",
                placeHolder = "123",
                onDone = {},
                onNext = {},
                onValueChange = {
//                    cvv = it
                },
                value = creditCard.cvv
            )
        }
        Spacer(Modifier.height(24.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked = isChecked,
                onCheckedChange = {isChecked = it}
            )
            Spacer(Modifier.width(11.06.dp))
            Text(
                "Save Card for another time",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 14.sp,
                    lineHeight = 14.35.sp,
                    color = if(isDarkMode) Color.White else Color.Black
                )
            )
        }

        Spacer(Modifier.height(32.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Save Changes",
            onClick = { onDone()}
        )
    }
}

@Preview
@Composable
fun EditCardPreview(){
    EditCard(rememberNavController(), CreditCard(1,"","",""),{})
}