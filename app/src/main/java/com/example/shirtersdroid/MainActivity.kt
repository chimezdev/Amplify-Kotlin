package com.example.shirtersdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amplifyframework.core.Amplify
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.example.shirtersdroid.ui.home.HomeActivity
import com.example.shirtersdroid.ui.onboarding.ConfirmSignUpScreen
import com.example.shirtersdroid.ui.onboarding.FirstOnboardingScreen
import com.example.shirtersdroid.ui.theme.ShirtersDroidTheme
import com.example.shirtersdroid.ui.onboarding.LoginScreen
import com.example.shirtersdroid.ui.onboarding.SecondOnboardingScreen
import com.example.shirtersdroid.ui.onboarding.SignUpScreen
import com.example.shirtersdroid.ui.onboarding.SplashScreen
import timber.log.Timber

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize AWS Amplify
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())  // Add the Cognito plugin
            Amplify.configure(applicationContext)  // Configure Amplify
            Timber.i("Amplify initialized successfully")
        } catch (error: Exception) {
            Timber.e(error, "Failed to initialize Amplify")
        }

        installSplashScreen()
        enableEdgeToEdge()
        val navOptions = NavOptions.Builder()
            .setPopUpTo(OnboardingDirections.firstScreen, true)
            .build()

        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, true)
            val navController = rememberNavController()

            LaunchedEffect(Unit) {
                if (intent.getStringExtra("DESTINATION") == OnboardingDirections.loginScreen) {
                    navController.navigate(OnboardingDirections.loginScreen) {
                    }
                }
            }

            ShirtersDroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(
                        navController = navController,
                        startDestination = OnboardingDirections.splashScreen
                    ) {
                        composable(OnboardingDirections.splashScreen) {
                            SplashScreen() {
                                navController.popBackStack()
                                navController.navigate(OnboardingDirections.firstScreen, navOptions)
                            }
                        }
                        composable(OnboardingDirections.firstScreen) {
                            FirstOnboardingScreen(
                                onSkip = {
                                    navController.navigate(OnboardingDirections.loginScreen, navOptions)
                                },
                                onSwipe = {
                                    navController.navigate(OnboardingDirections.secondScreen)
                                }
                            )
                        }
                        composable(OnboardingDirections.secondScreen) {
                            SecondOnboardingScreen(
                                onForwardSwipe = {
                                    navController.navigate(OnboardingDirections.loginScreen, navOptions)
                                },
                                onBackwardSwipe = { navController.navigate(OnboardingDirections.firstScreen) }
                            )
                        }
                        composable(OnboardingDirections.loginScreen) {
                            LoginScreen(
                                gotoCreateAccount = { navController.navigate(OnboardingDirections.signUpScreen) },
                                gotoForgotPassword = {},
                                proceedToHome = {
                                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            )
                        }
                        composable(OnboardingDirections.signUpScreen) {
                            SignUpScreen(
                                proceedToConfirm = {
                                    navController.navigate(OnboardingDirections.confirmSignUpScreen)
                                }
                            )
                        }
                        composable(OnboardingDirections.confirmSignUpScreen) {
                            ConfirmSignUpScreen(
                                proceedToLogin = {
                                    navController.navigate(OnboardingDirections.loginScreen)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


object OnboardingDirections {
    const val splashScreen = "splashscreen"
    val firstScreen = "first_screen"
    val secondScreen = "second_screen"
    val loginScreen = "login_screen"
    val signUpScreen = "sign_up_screen"
    val confirmSignUpScreen = "confirm_sign_up_screen"
}
