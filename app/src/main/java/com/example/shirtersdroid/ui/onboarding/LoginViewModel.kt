package com.example.shirtersdroid.ui.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow


class LoginViewModel : ViewModel() {
    val uiState = MutableStateFlow(LoginUiState())

    fun updatePassword(password: String){
        uiState.value = uiState.value.copy(
            password = password
        )
    }

    fun updateEmail(email: String){
        uiState.value = uiState.value.copy(
            email = email
        )
    }
}

data class LoginUiState(
    val password:String = "",
    val email:String = "",
)