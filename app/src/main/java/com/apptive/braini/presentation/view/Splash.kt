package com.apptive.braini.presentation.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.apptive.braini.R
import com.apptive.braini.presentation.navigation.Screen
import com.apptive.braini.presentation.viewmodel.interfaces.ILoginViewModel
import com.apptive.braini.presentation.viewmodel.mock.LoginViewModelMock
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: ILoginViewModel = LoginViewModelMock(),
    navController: NavHostController
){
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()

        if (viewModel.isLoggedIn()) navController.navigate(Screen.Main.route)
        else                        navController.navigate(Screen.Login.route)
    }

    Splash(alpha = alphaAnim.value)
}


@Composable
fun Splash(alpha : Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff3767b0)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .alpha(alpha = alpha)
                .size(100.dp),
            painter = painterResource(id = R.drawable.img),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(15.dp))
        Image(
            modifier = Modifier.alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = null
        )
    }
}


