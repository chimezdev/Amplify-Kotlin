package com.example.shirtersdroid.ui.profile.cards

data class CreditCard(
    val image: Int?,
    val name: String,
    val cardNumber: String,
    val expDate: String,
    val cvv: String = "",
)