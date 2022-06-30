package com.apptive.braini.presentation.view.RoomCreate

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.braini.presentation.navigation.Screen

@Composable
fun ColumnScope.CreateBox(navController: NavController){
    Surface(
        shape = RoundedCornerShape(20),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .width(339.dp)
                .height(224.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(223, 227, 255),
                            Color(237, 236, 255)
                        )
                    )
                )
                .padding(top = 15.dp)
                .clickable {
                    navController.navigate(Screen.RoomCreate.route)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CodeBox()
        }
    }
    Spacer(modifier = Modifier.height(92.dp))
}

@Composable
private fun CodeBox(){
    Box(
        modifier = Modifier
            .width(285.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(20))
            .background(Color.White)
            .padding(start = 15.dp, end = 10.dp)
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "CODE:",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .width(45.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(30))
                    .background(color = Color(red = 198, green = 204, blue = 255))
                    .clickable { },
                contentAlignment = Alignment.Center){
                Text(
                    text = "완료",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun CodeBoxPreview() {
    Column {
        CreateBox(rememberNavController())
    }
}