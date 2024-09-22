package com.example.shirtersdroid.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.text.font.FontWeight
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
import com.example.shirtersdroid.ui.home.CheckOutDirections
import com.example.shirtersdroid.ui.home.ClickableRectangleText
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.profile.address.AddShippingAddress
import com.example.shirtersdroid.ui.profile.cards.CreditCard
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Checkout(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if(isDarkMode) Color.White else Color.Black
    val backgroundColor = if (isDarkMode) Color.Black else Color(0xFFF2F2F2)
    val creditCards = listOf(
        CreditCard(R.drawable.master_card, "John Doe", "2345-2233-2334-221", "12/24"),
    )
    val verticalScroll = rememberScrollState()
    var cardList by remember { mutableStateOf(false) }
    var addNewCard by remember { mutableStateOf(false) }
    var addShippingAddress by remember { mutableStateOf(false) }
    var editCard by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(false)


    Box{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = backgroundColor)
                .padding(horizontal = 24.dp, vertical = 26.5.dp)
                .verticalScroll(verticalScroll),
        ) {
            TopBar(
                title = "Checkout",
                onBackPressed = { navHostController.navigateUp() }
            )
            Spacer(Modifier.height(43.5.dp))
            Text(
                text = "Shipping Method",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 21.sp,
                    fontWeight = W600,
                    lineHeight = 21.53.sp,
                    color = textColor
                )
            )
            Spacer(Modifier.height(18.04.dp))
            SimpleDropdownMenu()
            Spacer(Modifier.height(40.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shipping Address",
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 21.sp,
                        fontWeight = W600,
                        lineHeight = 21.53.sp,
                        color = textColor,
                        textDecoration = TextDecoration.Underline
                    )
                )
                Image(
                    painter = painterResource(if (isDarkMode) R.drawable.dark_plus_icon else R.drawable.plus_icon),
                    contentDescription = "Add Shipping Address",
                    modifier = Modifier.clickable {
                        addShippingAddress = true
                    }
                )
            }

            Spacer(Modifier.height(43.5.dp))
            Text(
                text = "John Doe\n" +
                        "Apartment 2c\n" +
                        "2715 Ash Dr. San Jose, South Dakota 83475\n" +
                        "USA",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 16.sp,
                    fontWeight = W400,
                    lineHeight = 25.sp,
                    color = textColor
                )
            )
            Spacer(Modifier.height(28.31.dp))
            Text(
                text = "Payment Method",
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 21.sp,
                    fontWeight = W600,
                    lineHeight = 21.53.sp,
                    color = textColor
                )
            )
            Spacer(Modifier.height(15.5.dp))
            Row(
                modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                CardSelector(sizes = listOf("Credit Card", "Google Pay", "Apple Pay"),"Credit Card" )
            }
            Spacer(Modifier.height(19.82.dp))
            creditCards.forEach { card ->
                CardItem(
                    image = card.image,
                    name = card.name,
                    cardNumber = card.cardNumber,
                    expDate = card.expDate,
                    onDelete = {},
                    onEdit = {},
                    navHostController = navHostController
                )
                Spacer(Modifier.height(11.63.dp))
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
                        cardList = true
                    }
                )

            }

            Spacer(Modifier.height(59.85.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Products",
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W400,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
                Text(
                    text = "\$400",
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        fontFamily = epilogueFontFamily,
                        fontSize = 28.sp,
                        lineHeight = 28.7.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shipping Fee",
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W400,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
                Text(
                    text = "\$100",
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        fontFamily = epilogueFontFamily,
                        fontSize = 28.sp,
                        lineHeight = 28.7.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
            }
            Spacer(Modifier.height(20.43.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Est. Total",
                    style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontWeight = W400,
                        fontSize = 21.sp,
                        lineHeight = 21.53.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
                Text(
                    text = "\$500",
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        fontFamily = epilogueFontFamily,
                        fontSize = 28.sp,
                        lineHeight = 28.7.sp,
                        color = if (isDarkMode) Color.White else Color.Black
                    )
                )
            }
            Spacer(Modifier.height(31.05.dp))
            GenericButton(
                modifier = Modifier.fillMaxWidth(),
                label = "Continue",
                onClick = {
                    navHostController.navigate(CheckOutDirections.CHECKOUT_SUMMARY)
                }
            )
        }
        if(cardList){
            ModalBottomSheet(
                onDismissRequest = {
                    cardList = false
                },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle()},
                content = {
                   AllCreditCards (
                       navHostController = navHostController,
                       onDone = {cardList = false},
                       addNewCard = {
                           cardList = false
                           addNewCard = true
                       },
                       onEdit = {creditCards->
                            editCard = true
                       }
                   )
                }
            )
        }
        if(addNewCard){
            ModalBottomSheet(
                onDismissRequest = {
                    addNewCard = false
                },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle()},
                content = {
                    AddCard(
                        navHostController,
                        onDone = {addNewCard = false}
                        )
                }
            )
        }
        if (editCard){
            ModalBottomSheet(
                onDismissRequest = {
                    editCard = false
                },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle()},
                content = {
                    EditCard(
                        navHostController,
                        creditCard = creditCards[0],
                        onDone = {editCard = false}
                    )
                }
            )
        }
        if (addShippingAddress){
            ModalBottomSheet(
                onDismissRequest = {
                    addShippingAddress = false
                },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle()},
                content = {
                    AddShippingAddress(
                        navHostController,
                        onDone = {addShippingAddress = false}
                    )
                }
            )
        }
    }

}

@Composable
fun CardItem(
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

@Composable
fun CardSelector(
    sizes: List<String>,
    initialSelectedSize: String
) {
    var selectedSize by remember { mutableStateOf(initialSelectedSize) }
    val isDarkMode = isSystemInDarkTheme()
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier.fillMaxWidth(),//.horizontalScroll(scrollState).width(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        sizes.forEach { size ->
            ClickableRectangleText(
                text = size,
                isToggled = size == selectedSize,
                width = 116.82f,
                height = 64f,
                initialTextColor = if (isDarkMode) Color.White else Color.Black,
                initialBackgroundColor = if (isDarkMode) Color.Black else Color.White,
                toggledTextColor = if (isDarkMode) Color.Black else Color.White,
                toggledBackgroundColor = if (isDarkMode) Color.White else Color.Black,
                onClick = {
                    selectedSize = size
                }
            )
        }
    }
}

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    //val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(8.dp))
    ) {
        TextField(
            readOnly = true,
            value = selectedOption,
            onValueChange = { },
            label = { Text("Pick from store") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor() // Aligns the dropdown menu with the text field
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    text = { Text(option) },
//                    onClick = {
//                        selectedOption = option
//                        expanded = false
//                    }
//                )
//            }
        }
    }
}


@Preview
@Composable
fun CheckoutPreview(){
    Checkout(rememberNavController())
}