package com.apptive.braini.presentation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun requireContext(): Context = LocalContext.current

fun Context.getActivity() = this as ComponentActivity

fun Modifier.size(size: Size) = this.then(
fun NavController.popNavigate(route: String) {
    this.popBackStack()
    this.navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}