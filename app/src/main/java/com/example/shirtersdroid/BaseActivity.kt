package com.example.shirtersdroid

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

abstract class BaseActivity:ComponentActivity(), ShirtersApplication.LogoutListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        ShirtersApplication.userSessionStart()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        ShirtersApplication.userSessionStart()
    }

    override fun onResume() {
        super.onResume()
        ShirtersApplication.registerSessionListener(this)
    }


    abstract fun logoutUser()
    override fun onSessionLogout() {
        logoutUser()
    }
    fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

}