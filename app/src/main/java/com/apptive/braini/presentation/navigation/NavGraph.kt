package com.apptive.braini.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apptive.braini.presentation.view.LoginScreen
import com.apptive.braini.presentation.view.RoomCreateScreen
import com.apptive.braini.presentation.view.MainScreen
import com.apptive.braini.presentation.view.SplashScreen
import com.apptive.braini.presentation.viewmodel.LoginViewModel

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController =navController ,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Splash.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            SplashScreen(viewModel, navController)
        }
        composable(route = Screen.Login.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel, navController)
        }
        composable(route = Screen.RoomSelect.route) {
            RoomCreateScreen()
        }
        composable(route = Screen.RoomCreate.route) {
            MainScreen()
        }
    }
}