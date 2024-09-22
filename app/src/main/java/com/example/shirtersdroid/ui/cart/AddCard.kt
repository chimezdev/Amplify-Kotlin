package com.example.shirtersdroid.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextDecoration
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
import com.example.shirtersdroid.ui.profile.cards.CreditCard
import com.example.shirtersdroid.ui.profile.cards.SavedCreditCardItem
import com.example.shirtersdroid.ui.theme.darkTextColor
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun AddCard(
    navHostController: NavHostController,
    onDone: () -> Unit,
){
    val isDarkMode = isSystemInDarkTheme()
    var cardNumber by remember { mutableStateOf("") }
    var cardName by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Add Credit Card",
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
        

        Spacer(Modifier.height(56.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add Card",
            onClick = { onDone() }
        )
    }
}

@Composable
fun AllCreditCards(
    navHostController: NavHostController,
    addNewCard:()->Unit,
    onDone:() -> Unit,
    onEdit: (CreditCard) -> Unit,
){
    val isDarkMode = isSystemInDarkTheme()
    val creditCards = listOf(
        CreditCard(R.drawable.master_card, "John Doe", "2345-2233-2334-221", "12/24"),
        CreditCard(R.drawable.visa, "Jane Doe", "1234-5678-9012-3456", "11/23"),
        CreditCard(R.drawable.visa, "Sam Smith", "9876-5432-1098-7654", "10/22")
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Add Credit Card",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        creditCards.forEach { card ->
            CreditCardItem(
                image = card.image,
                name = card.name,
                cardNumber = card.cardNumber,
                expDate = card.expDate,
                onEdit = onEdit,
                navHostController = navHostController
            )
            Spacer(Modifier.height(16.dp))
        }
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Add New Card",
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 14.sp,
                lineHeight = 14.35.sp,
                color = if (isDarkMode) Color.White else Color.Black,
            ),
            modifier = Modifier.align(Alignment.End).clickable {
                addNewCard()
            }
        )
        Spacer(Modifier.height(32.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add Credit Card",
            onClick = {
                onDone()
            }
        )
    }

}

@Composable
fun CreditCardItem(
    image: Int?,
    name: String,
    cardNumber: String,
    expDate: String,
    onEdit:(CreditCard)->Unit,
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    val textStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontWeight = W400,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        color = if (isDarkMode) Color.White else Color.Black
    )
    var selected by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isDarkMode) Color(0xFF333333) else Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            image?.let { painterResource(it) }?.let {
                Image(
                    painter = it,
                    contentDescription = null
                )
            }
        }
        Row {
            Column {
                Text(text = name, style = textStyle)
                Spacer(Modifier.height(2.dp))
                Text(text = cardNumber, style = textStyle)
                Spacer(Modifier.height(2.dp))
                Text(text = expDate, style = textStyle)
            }
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RadioButton(
                    selected = selected,
                    onClick = {selected = !selected},
                    colors = RadioButtonDefaults.colors().copy(
                        selectedColor = Color.Black,
                        unselectedColor = Color.White
                    )
                )
                Spacer(Modifier.width(10.2.dp))
                Image(
                    modifier = Modifier.size(24.dp).clickable {
                        onEdit(
                            CreditCard(
                            name = name,
                            cardNumber = cardNumber,
                            expDate = expDate,
                            image = null
                        )
                        )
                        navHostController.navigate(HomeDirections.SAVED_CREDIT_CARD_EDIT)
                    },
                    painter = painterResource(if (isDarkMode) R.drawable.dark_edit_square else R.drawable.edit_square),
                    contentDescription = "Edit Address"
                )
            }
        }
    }
}

@Preview
@Composable
fun AddCardPreview(){
    //AddCard(rememberNavController())
//    AllCreditCards(rememberNavController(),{},{(CreditCard(1,"","",""))})
}
