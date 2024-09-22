package com.example.shirtersdroid.ui.profile

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.MainActivity
import com.example.shirtersdroid.OnboardingDirections
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.home.HomeDirections
import com.example.shirtersdroid.ui.theme.buttonStyle
import com.example.shirtersdroid.ui.theme.disabledButtonColor
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun Profile(
    navHostController: NavHostController
) {
    ProfileContent(navHostController = navHostController)
}

@Composable
fun ProfileContent(
    navHostController: NavHostController,
) {
    val isDarkMode = isSystemInDarkTheme()
    val scrollState = rememberScrollState()
    val textColor = if (isDarkMode) Color.White else Color.Black
    val sectionHeaderStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontSize = 18.sp,
        fontWeight = W400,
        lineHeight = 18.45.sp,
        color = textColor
    )
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()

            .background(if (isDarkMode) Color.Black else Color(0xFFF2F2F2)).padding(24.dp)
            .verticalScroll(scrollState)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(92.23.dp).align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.profile_icon),
                contentDescription = "Profile Picture"
            )
            Spacer(Modifier.height(12.59.dp))
            Text(
                "John Doe", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 18.sp,
                    lineHeight = 18.45.sp,
                    color = textColor
                )
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "johndoe@gmail.com", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W400,
                    fontSize = 14.sp,
                    lineHeight = 14.3.sp,
                    color = textColor
                )
            )
            Spacer(Modifier.height(14.52.dp))
            OutlinedButton(
                modifier = Modifier, enabled = true, onClick = {
                    navHostController.navigate(HomeDirections.EDIT_PROFILE)
                }, shape = RectangleShape, colors = ButtonColors(
                    contentColor = if (isDarkMode) Color.Black else Color.White,
                    containerColor = if (isDarkMode) Color.White else Color.Black,
                    disabledContentColor = if (isDarkMode) Color.White else Color.Black,
                    disabledContainerColor = disabledButtonColor
                )
            ) {
                Text(
                    modifier = Modifier.clickable { navHostController.navigate(HomeDirections.EDIT_PROFILE) },
                    text = "Edit Profile",
                    textAlign = TextAlign.Center,
                    style = buttonStyle,
                )

            }
        }
        Spacer(Modifier.height(24.65.dp))


        Text(
            "General",
            style = sectionHeaderStyle,
            modifier = Modifier.fillMaxWidth()
                .background(if (isDarkMode) Color.Transparent else Color(0xFFF7F7F7))
                .padding(vertical = 15.dp, horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Wishlist",
            leadingIcon = if (isDarkMode) R.drawable.dark_wishlist else R.drawable.wishlist,
            onClick = { navHostController.navigate(HomeDirections.WISH_LIST) }
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Password Reset",
            leadingIcon = if (isDarkMode) R.drawable.dark_password_reset else R.drawable.password_reset,
            onClick = { navHostController.navigate(HomeDirections.PASSWORD_RESET) }
        )
        Spacer(Modifier.height(39.dp))

        Text(
            "Shopping",
            style = sectionHeaderStyle,
            modifier = Modifier.fillMaxWidth()
                .background(if (isDarkMode) Color.Transparent else Color(0xFFF7F7F7))
                .padding(vertical = 15.dp, horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Shipping Address",
            leadingIcon = if (isDarkMode) R.drawable.dark_shipping_address else R.drawable.shipping_address,
            onClick = { navHostController.navigate(HomeDirections.SHIPPING_ADDRESS_LIST) }
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Saved Credit Card",
            leadingIcon = if (isDarkMode) R.drawable.dark_saved_credit_card else R.drawable.saved_credit_card,
            onClick = { navHostController.navigate(HomeDirections.SAVED_CREDIT_CARD) }
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Order History",
            leadingIcon = if (isDarkMode) R.drawable.dark_order_history else R.drawable.order_history,
            onClick = { navHostController.navigate(HomeDirections.ORDER_HISTORY) }
        )
        Spacer(Modifier.height(39.dp))

        Text(
            "Preference",
            style = sectionHeaderStyle,
            modifier = Modifier.fillMaxWidth()
                .background(if (isDarkMode) Color.Transparent else Color(0xFFF7F7F7))
                .padding(vertical = 15.dp, horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Dark Mode",
            leadingIcon = if (isDarkMode) R.drawable.dark_dark_mode else R.drawable.dark_mode,
            showToggle = true
        ) {

        }
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Receive Notifications",
            leadingIcon = if (isDarkMode) R.drawable.dark_receive_notification else R.drawable.receive_notification,
            showToggle = true
        ) {

        }
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Become a Seller",
            leadingIcon = if (isDarkMode) R.drawable.dark_become_seller else R.drawable.become_seller,
            onClick = { navHostController.navigate(HomeDirections.SELLER) }
        )
        Spacer(Modifier.height(39.dp))

        Text(
            "Others",
            style = sectionHeaderStyle,
            modifier = Modifier.fillMaxWidth()
                .background(if (isDarkMode) Color.Transparent else Color(0xFFF7F7F7))
                .padding(vertical = 15.dp, horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Report",
            leadingIcon = if (isDarkMode) R.drawable.dark_report else R.drawable.report,
            onClick = {navHostController.navigate(HomeDirections.REPORT)}
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "FAQs",
            leadingIcon = if (isDarkMode) R.drawable.dark_faqs else R.drawable.faqs,
            onClick = { navHostController.navigate(HomeDirections.FAQS) }
        )
        Spacer(Modifier.height(8.dp))
        ProfileSection(
            text = "Logout",
            leadingIcon = if (isDarkMode) R.drawable.dark_logout else R.drawable.logout,
            onClick = {
                val intent = Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    // Add an extra to indicate we want to go to the login screen
                    putExtra("DESTINATION", OnboardingDirections.loginScreen)
                }

                context.startActivity(intent)
            }
        )
        Spacer(Modifier.height(20.dp))
    }
}

@Composable
fun ProfileSection(
    text: String,
    showToggle: Boolean = false,
    leadingIcon: Int,
    onClick: () -> Unit = {},
) {
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color.White else Color.Black
    val bgColor = if (isDarkMode) Color(0xFF333333) else Color.White
    var isToggled by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth().background(bgColor)
            .padding(vertical = 16.dp, horizontal = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(leadingIcon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Spacer(Modifier.width(18.dp))
            Text(
                text = text, style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 16.4.sp,
                    color = textColor
                )
            )
        }

        if (showToggle) {
            Switch(
                checked = isToggled, onCheckedChange = {
                    isToggled = it
                    onClick()
                }, colors = SwitchDefaults.colors(

                )
            )
        } else {
            Image(painter = painterResource(if (isDarkMode) R.drawable.black_arrow_right else R.drawable.white_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(24.dp).clickable {
                    onClick()
                })
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfilePreview() {
    ProfileContent(
        navHostController = rememberNavController()
    )
}