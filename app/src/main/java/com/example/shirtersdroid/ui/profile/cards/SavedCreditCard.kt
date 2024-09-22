package com.example.shirtersdroid.ui.profile.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun SavedCreditCard(navHostController: NavHostController) {
    val isDarkMode = isSystemInDarkTheme()
    val verticalScrollState = rememberScrollState()

    // List of credit card data
    val creditCards = listOf(
        CreditCard(R.drawable.master_card, "John Doe", "2345-2233-2334-221", "12/24"),
        CreditCard(R.drawable.visa, "Jane Doe", "1234-5678-9012-3456", "11/23"),
        CreditCard(R.drawable.visa, "Sam Smith", "9876-5432-1098-7654", "10/22")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp)
            .verticalScroll(verticalScrollState),
    ) {
        TopBar(
            title = "Saved Credit Card",
            onBackPressed = { navHostController.navigateUp() }
        )

        Spacer(Modifier.height(38.5.dp))

        // Loop through the list of credit cards
        creditCards.forEach { card ->
            SavedCreditCardItem(
                image = card.image,
                name = card.name,
                cardNumber = card.cardNumber,
                expDate = card.expDate,
                onDelete = {},
                onEdit = {},
                navHostController = navHostController
            )
            Spacer(Modifier.height(16.dp))
        }

        Spacer(Modifier.height(20.18.dp))

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
                navHostController.navigate(HomeDirections.SAVED_CREDIT_CARD_ADD)
            }
        )
    }
}

@Composable
fun SavedCreditCardItem(
    image: Int?,
    name: String,
    cardNumber: String,
    expDate: String,
    onEdit:(CreditCard)->Unit,
    onDelete:()->Unit,
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    val textStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontWeight = W400,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        color = if (isDarkMode) Color.White else Color.Black
    )

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
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(28.07.dp).clickable {
                        onDelete()
                    },
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "Delete Address"
                )
                Spacer(Modifier.width(10.2.dp))
                Image(
                    modifier = Modifier.size(24.dp).clickable {
                        onEdit(CreditCard(
                            name = name,
                            cardNumber = cardNumber,
                            expDate = expDate,
                            image = null
                        ))
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
fun SavedCreditCardPreview() {
    SavedCreditCard(rememberNavController())
}
