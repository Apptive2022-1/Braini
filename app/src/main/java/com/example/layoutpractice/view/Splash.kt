package com.example.layoutpractice.view

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutpractice.R

@Composable
fun SplashScreen(){
       Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(55, 103, 706)),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.img), contentDescription = null)
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.img_1), contentDescription = null)
    }
}

@Preview
@Composable
fun SplashScreenPre(){
    SplashScreen()
}

