package com.apptive.braini.presentation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.apptive.braini.presentation.model.Size

@Composable
fun requireContext(): Context = LocalContext.current

fun Context.getActivity() = this as ComponentActivity

fun Modifier.size(size: Size) = this.then(
    Modifier.width(size.width).height(size.height)
)

fun NavController.popNavigate(route: String) {
    this.popBackStack()
    this.navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}