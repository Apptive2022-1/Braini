package com.apptive.braini.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("screen_splash")
    object Login : Screen("screen_login")
    object RoomCreate : Screen("screen_room_select")
    object Main : Screen("screen_room_create")
}
