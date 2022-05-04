package com.example.braini.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("screen_splash")
}
