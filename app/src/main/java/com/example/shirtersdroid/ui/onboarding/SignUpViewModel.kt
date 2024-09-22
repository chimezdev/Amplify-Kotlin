package com.example.shirtersdroid.ui.onboarding

import androidx.lifecycle.ViewModel
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber

class SignUpViewModel : ViewModel() {
    val uiState = MutableStateFlow(UiState())

    fun updateUsername(username: String) {
        uiState.value = uiState.value.copy(
            username = username
        )
    }

    fun updatePassword(password: String) {
        uiState.value = uiState.value.copy(
            password = password
        )
    }

    fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    fun updateConfirmationCode(code: String) {
        uiState.value = uiState.value.copy(
            confirmationCode = code
        )
    }

    // Method for handling the sign-up process with Amplify
    fun signUpUser() {
        val username = uiState.value.username
        val password = uiState.value.password
        val email = uiState.value.email

        val options = AuthSignUpOptions.builder()
            .userAttribute(AuthUserAttributeKey.email(), email)
            .build()

        Amplify.Auth.signUp(username, password, options,
            { result ->
                Timber.i("Sign up succeeded: %s", result)
                val deliveryDetails = result.nextStep.signUpStep // Handle the delivery details if necessary
            },
            { error -> Timber.e(error, "Sign up failed") }
        )
    }

    // Confirm sign-up method
    fun confirmSignUp() {
        val username = uiState.value.username
        val confirmationCode = uiState.value.confirmationCode

        Amplify.Auth.confirmSignUp(username, confirmationCode,
            { result ->
                if (result.isSignUpComplete) {
                    Timber.i("Confirm sign-up succeeded")
                } else {
                    Timber.i("Confirm sign-up not complete")
                }
            },
            { error -> Timber.e(error, "Failed to confirm sign up") }
        )
    }
}

data class UiState(
    val password: String = "",
    val username: String = "",
    val email: String = "",
    val confirmationCode: String = "" // store the verification code
)
