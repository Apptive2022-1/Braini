package com.apptive.braini.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            CloudImage()
            RoomCreateText()
        }
    }
}

@Composable
fun ColumnScope.CloudImage(){
    Image(modifier = Modifier
        .size(150.dp),
        painter = painterResource(id = R.drawable.loading_cloud),
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