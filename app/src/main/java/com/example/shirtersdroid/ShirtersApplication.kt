package com.example.shirtersdroid

import android.app.Application
import timber.log.Timber
import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Amplify
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import java.util.Timer
import java.util.TimerTask

class ShirtersApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Timber logging setup
        if (BuildConfig.IS_LOGGING_ENABLED) {
            Timber.plant(Timber.DebugTree())
        }

        // AWS Amplify initialization
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Timber.tag("ShirtersDroid").i("Initialized Amplify")
        } catch (error: AmplifyException) {
            Timber.tag("ShirtersDroid").e(error, "Could not initialize Amplify")
        }
    }

    companion object {
        private var logoutListener: LogoutListener? = null
        private var timer: Timer? = null
        private var sessionTimeIntervalMillis: Long = 0

        fun userSessionStart(timeIntervalMillis: Long = 1000 * 60 * 10) {
            if (timer != null) {
                timer?.cancel()
            }
            timer = Timer()
            timer?.schedule(object : TimerTask() {
                override fun run() {
                    logoutListener?.onSessionLogout()
                }
            }, timeIntervalMillis)
            sessionTimeIntervalMillis = timeIntervalMillis
        }

        fun registerSessionListener(listener: BaseActivity) {
            logoutListener = listener
        }

        fun resetSession() {
            userSessionStart(sessionTimeIntervalMillis)
        }
    }

    interface LogoutListener {
        fun onSessionLogout()
    }
}
