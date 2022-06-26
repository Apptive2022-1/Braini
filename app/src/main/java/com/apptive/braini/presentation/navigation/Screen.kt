package com.apptive.braini.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("screen_splash")
    object Login : Screen("screen_login")
    object Main : Screen("screen_room_ Main")
    object RoomCreate : Screen("screen_room_Create")
    object MemoTypeSelect : Screen("screen_MemoTypeSelect")
    object RoomCreateSucceed : Screen("screen_RoomCreateSucceed")
}
