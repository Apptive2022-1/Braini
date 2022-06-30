package com.apptive.braini.presentation.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R
import com.apptive.braini.presentation.size

@Composable
fun LoadingScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    contentAlignment = Alignment.Center){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .background(color = Color.Gray)
            ){
                LoadingCircle()
                CloudImage()
            }
            RoomCreateText()
        }
    }
}

@Composable
fun CloudImage(){
    Image(modifier = Modifier
        .size(150.dp),
        painter = painterResource(id = R.drawable.loading_cloud),
        contentDescription = null)
}

@Composable
fun LoadingCircle(){
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

    Image(modifier = Modifier
        .graphicsLayer {
            rotationZ = angle
        }
        .size(150.dp),
        painter = painterResource(id = R.drawable.loading_circle),
          contentDescription = null)
}

@Composable
fun ColumnScope.RoomCreateText(){
    Text(text = "방을 만드는 중...",
    fontSize = 23.sp)
}

@Preview
@Composable
fun preLoading(){
    LoadingScreen()
}