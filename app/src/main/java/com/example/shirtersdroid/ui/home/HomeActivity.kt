package com.example.shirtersdroid.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.BaseActivity
import com.example.shirtersdroid.MainActivity
import com.example.shirtersdroid.ui.cart.Cart
import com.example.shirtersdroid.ui.cart.CheckOutSummary
import com.example.shirtersdroid.ui.cart.Checkout
import com.example.shirtersdroid.ui.profile.EditProfile
import com.example.shirtersdroid.ui.profile.Profile
import com.example.shirtersdroid.ui.profile.address.AddShippingAddress
import com.example.shirtersdroid.ui.profile.address.EditShippingAddress
import com.example.shirtersdroid.ui.profile.address.ShippingAddress
import com.example.shirtersdroid.ui.profile.cards.AddNewCreditCard
import com.example.shirtersdroid.ui.profile.cards.EditCreditCard
import com.example.shirtersdroid.ui.profile.cards.SavedCreditCard
import com.example.shirtersdroid.ui.profile.faqs.Faqs
import com.example.shirtersdroid.ui.profile.orderhistory.OrderHistory
import com.example.shirtersdroid.ui.profile.orderhistory.OrderSummary
import com.example.shirtersdroid.ui.profile.password.ConfirmPassword
import com.example.shirtersdroid.ui.profile.password.PasswordReset
import com.example.shirtersdroid.ui.profile.report.Report
import com.example.shirtersdroid.ui.profile.seller.BecomeSeller
import com.example.shirtersdroid.ui.profile.seller.SuccessfulShopSetup
import com.example.shirtersdroid.ui.profile.wishlist.WishList
import com.example.shirtersdroid.ui.theme.ShirtersDroidTheme

class HomeActivity: BaseActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        setContent {
            val navController = rememberNavController()
            ShirtersDroidTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
//                        if (currentRoute in ) {
                            BottomNavBar(navController = navController)
//                        }
                    }
                ) {innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(navController = navController)
                    }
                }
            }
        }
    }

    override fun logoutUser() {
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }
}

val exemptedDirection = listOf(HomeDirections.PRODUCT_DETAIL, HomeDirections.NOTIFICATIONS, )

object HomeDirections{
    const val PRODUCT_DETAIL = "Product Detail"
    const val NOTIFICATIONS  = "notifications"
    const val EDIT_PROFILE  = "edit_profile"
    const val WISH_LIST  = "wish_list"
    const val PASSWORD_RESET  = "password_reset"
    const val PASSWORD_RESET_NEW  = "password_reset_new"
    const val SHIPPING_ADDRESS  = "shipping_address"
    const val SHIPPING_ADDRESS_EDIT  = "shipping_address_edit"
    const val SHIPPING_ADDRESS_LIST  = "shipping_address_list"
    const val SAVED_CREDIT_CARD  = "saved_credit_card"
    const val SAVED_CREDIT_CARD_ADD  = "saved_credit_card_add"
    const val SAVED_CREDIT_CARD_EDIT  = "saved_credit_card_edit"
    const val ORDER_HISTORY  = "order_history"
    const val ORDER_HISTORY_SUMMARY  = "order_history_summary"
    const val SELLER  = "seller"
    const val SELLER_SUCCESS  = "seller_success"
    const val REPORT  = "report"
    const val FAQS  = "faqs"
}

object CheckOutDirections{
    const val CHECKOUT_SUMMARY = "checkout_add_card"
    const val CART = "Cart"
    const val CHECKOUT = "checkout"

}

object BottonBarDirections{
    val home = "Home"
    val profile = "Profile"
    val design = "Design"

}



@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "Home") {
        composable(BottonBarDirections.home) { LandingScreen(navController = navController) }
        composable(BottonBarDirections.design) {  }
        composable(CheckOutDirections.CART) { Cart(navHostController = navController) }
        composable(CheckOutDirections.CHECKOUT) { Checkout(navHostController = navController) }
        composable(CheckOutDirections.CHECKOUT_SUMMARY) { CheckOutSummary(navHostController = navController) }
        composable(BottonBarDirections.profile) { Profile(navHostController = navController) }
        composable(HomeDirections.PRODUCT_DETAIL){ OfficialProductScreen(navController = navController) }
        composable(HomeDirections.NOTIFICATIONS){ NotificationScreen(navHostController = navController)}
        composable(HomeDirections.EDIT_PROFILE){ EditProfile(navHostController = navController) }
        composable(HomeDirections.WISH_LIST){ WishList(navHostController = navController) }
        composable(HomeDirections.PASSWORD_RESET){ PasswordReset(navHostController = navController) }
        composable(HomeDirections.PASSWORD_RESET_NEW){ ConfirmPassword(navHostController = navController) }
        composable(HomeDirections.SHIPPING_ADDRESS){ AddShippingAddress(navHostController = navController) }
        composable(HomeDirections.SHIPPING_ADDRESS_EDIT){ EditShippingAddress(navHostController = navController) }
        composable(HomeDirections.SHIPPING_ADDRESS_LIST){ ShippingAddress(navHostController = navController) }
        composable(HomeDirections.SAVED_CREDIT_CARD){ SavedCreditCard(navHostController = navController) }
        composable(HomeDirections.SAVED_CREDIT_CARD_ADD){ AddNewCreditCard(navHostController = navController) }
        composable(HomeDirections.SAVED_CREDIT_CARD_EDIT){ EditCreditCard(navHostController = navController) }
        composable(HomeDirections.ORDER_HISTORY){ OrderHistory(navHostController = navController) }
        composable(HomeDirections.ORDER_HISTORY_SUMMARY){ OrderSummary(navHostController = navController) }
        composable(HomeDirections.SELLER){ BecomeSeller(navHostController = navController) }
        composable(HomeDirections.SELLER_SUCCESS){ SuccessfulShopSetup(navHostController = navController) }
        composable(HomeDirections.REPORT){ Report(navHostController = navController) }
        composable(HomeDirections.FAQS){ Faqs(navHostController = navController) }
    }
}