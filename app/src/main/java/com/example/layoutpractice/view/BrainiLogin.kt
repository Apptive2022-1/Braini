package com.apptive.braini.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R

@Composable
fun BLogin(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(listOf(Color(55, 103, 706), Color(143, 171, 217))),
            shape = RectangleShape
        )) {
       Text(text = "Hello!",
           modifier = Modifier
               .width(200.dp)
               .padding(20.dp)
               .padding(top = 20.dp),
       fontSize = 50.sp,
       color = Color.White,
       textAlign = TextAlign.Center)
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)){
            Box(modifier =Modifier.fillMaxSize()){
                Image(painter = painterResource(id = R.drawable.small_cloud), contentDescription = null)
            }
            Box(modifier = Modifier.fillMaxSize()){
                Image(painter = painterResource(id = R.drawable.middle_cloud), contentDescription = null)
                Image(painter = painterResource(id = R.drawable.middle_cloud_line), contentDescription = null)
            }
            Box(modifier = Modifier.fillMaxSize()){
                Image(painter = painterResource(id = R.drawable.middle_cloud), contentDescription = null)
                Image(painter = painterResource(id = R.drawable.large_cloud_line), contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun BPreview(){
    BLogin()
}