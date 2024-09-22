package com.example.shirtersdroid.ui.profile.address

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.shirtersdroid.ui.components.PasswordField1
import com.example.shirtersdroid.ui.components.SOutlinedButton
import com.example.shirtersdroid.ui.components.TextField1
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.home.MessageOverlay
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun ShippingAddress(navHostController: NavHostController){
    val isDarkMode = isSystemInDarkTheme()
    val verticalScrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp)
            .verticalScroll(verticalScrollState),
    ) {
        TopBar(
            title = "Shipping Address",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(38.5.dp))
        ShippingItem(navHostController = navHostController)
        Spacer(Modifier.height(20.18.dp))
        Text(
            text = "Add Shipping Address", style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 14.sp,
                lineHeight = 14.35.sp,
                color = if(isDarkMode) Color.White else Color.Black,
            ),
            modifier = Modifier.align(Alignment.End).clickable {
                navHostController.navigate(HomeDirections.SHIPPING_ADDRESS)
            }
        )
    }
}

@Composable
fun ShippingItem(
    name:String = "John Doe",
    buildingNo: String = "Apartment 2c",
    address:String = "2715 Ash Dr. San Jose, South Dakota 83475",
    country:String = "USA",
    navHostController: NavHostController,
){
    val isDarkMode = isSystemInDarkTheme()
    val textStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontWeight = W400,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        color = if (isDarkMode) Color.White else Color.Black
    )
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(if (isDarkMode)Color(0xFF333333) else Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = name, style = textStyle
            )
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(28.07.dp),
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "Delete Address"
                )
                Spacer(Modifier.width(10.2.dp))
                Image(
                    modifier = Modifier.size(24.dp).clickable {
                        navHostController.navigate(HomeDirections.SHIPPING_ADDRESS_EDIT)
                    },
                    painter = painterResource(if (isDarkMode) R.drawable.dark_edit_square else R.drawable.edit_square),
                    contentDescription = "Edit Address"
                )
            }
        }

        Text(
            text = buildingNo, style = textStyle
        )
        Text(
            text = address, style = textStyle
        )
        Text(
            text = country, style = textStyle
        )

    }
}

@Composable
fun AddShippingAddress(
    navHostController: NavHostController,
    onDone:()->Unit = {}
){
    val isDarkMode = isSystemInDarkTheme()
    var address by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var isPasswordUpdated by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Shipping Address",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        TextField1(
            label = "Address",
            placeHolder = "2345-2233-2334-221",
            value = address,
            onValueChange = { address = it },
            onNext = {},
            onDone = {}
        )
        Spacer(Modifier.height(28.dp))
        TextField1(
            label = "Name",
            placeHolder = "John Doe",
            value = name,
            onValueChange = { name = it },
            onNext = {},
            onDone = {}
        )
        Spacer(Modifier.height(28.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField1(
                modifier = Modifier.width(186.dp),
                label = "Building No.",
                placeHolder = "12C",
                value = name,
                onValueChange = { name = it },
                onNext = {},
                onDone = {}
            )
            Spacer(Modifier.width(16.14.dp))
            TextField1(
                modifier = Modifier.width(186.dp),
                label = "Country",
                placeHolder = "863",
                value = name,
                onValueChange = { name = it },
                onNext = {},
                onDone = {}
            )
        }
        Spacer(Modifier.height(56.dp))
        SOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Add Shipping Address",
            onClick = { onDone() }
        )
    }
}

@Composable
fun EditShippingAddress(
    navHostController: NavHostController
){
    val isDarkMode = isSystemInDarkTheme()
    var address by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var isPasswordUpdated by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "Edit Address",
            onBackPressed = {navHostController.navigateUp()}
        )
        Spacer(Modifier.height(46.5.dp))
        TextField1(
            label = "Address",
            placeHolder = "2345-2233-2334-221",
            value = address,
            onValueChange = { address = it },
            onNext = {},
            onDone = {}
        )
        Spacer(Modifier.height(28.dp))
        TextField1(
            label = "Name",
            placeHolder = "John Doe",
            value = name,
            onValueChange = { name = it },
            onNext = {},
            onDone = {}
        )
        Spacer(Modifier.height(28.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField1(
                modifier = Modifier.width(186.dp),
                label = "Building No.",
                placeHolder = "12C",
                value = name,
                onValueChange = { name = it },
                onNext = {},
                onDone = {}
            )
            Spacer(Modifier.width(16.14.dp))
            TextField1(
                modifier = Modifier.width(186.dp),
                label = "Country",
                placeHolder = "863",
                value = name,
                onValueChange = { name = it },
                onNext = {},
                onDone = {}
            )
        }
        Spacer(Modifier.height(56.dp))
        SOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Save Changes",
            onClick = {}
        )
    }
}


@Preview
@Composable
fun ShippingAddressPreview(){
    ShippingAddress(rememberNavController())
}