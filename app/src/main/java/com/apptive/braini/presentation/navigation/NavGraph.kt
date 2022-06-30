package com.apptive.braini.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apptive.braini.presentation.view.*
import com.apptive.braini.presentation.viewmodel.LoginViewModel
import com.apptive.braini.presentation.viewmodel.RoomCreateViewModel

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController =navController ,
        startDestination = Screen.Main.route
    ){
        composable(route = Screen.Splash.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            SplashScreen(viewModel, navController)
        }
        composable(route = Screen.Login.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel, navController)
        }
        composable(route = Screen.Main.route) {
            MainScreen(navController)
        }
        composable(route = Screen.RoomCreate.route) {
            val viewModel = hiltViewModel<RoomCreateViewModel>()
            RoomCreateScreen(viewModel,navController)
        }
        composable(route = Screen.MemoTypeSelect.route) {
            val viewModel = hiltViewModel<RoomCreateViewModel>()
            RoomCreateScreen(viewModel,navController)
        }
        composable(route = Screen.RoomCreateSucceed.route) {
            RoomCreateSucceedScreen(navController)
        }

    }
}