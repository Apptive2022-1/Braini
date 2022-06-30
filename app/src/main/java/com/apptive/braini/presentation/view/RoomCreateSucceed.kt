package com.apptive.braini.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R
import com.apptive.braini.presentation.height
import com.apptive.braini.presentation.width

@Composable
fun RoomCreateSucceedScreen(){
    RoomCreateSucceedContent {
        RoomCreateSucceedBox()
    }
}


@Composable
private fun RoomCreateSucceedContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(76)
            .height(30)
            .wrapContentSize(Alignment.Center),
//            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
private fun RoomCreateSucceedBox(){
    Surface(
        shape = RoundedCornerShape(10),
//        elevation = 10.dp
    ){
        Column(
            modifier = Modifier
                .width(76)
                .height(30)
                .background(
                    color = Color(221, 229, 255)
//                    color = Color(185,204,255,100)
                )
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SucceedContent()
        }
    }
}

@Composable
private fun SucceedContent(){
    Image(
        painter = painterResource(id = R.drawable.congratulation),
        contentDescription = null,
        modifier = Modifier.size(125.dp)
    )
//    Spacer(modifier = Modifier.height(1))
    Text(
        text = "방이 완성되었습니다!",
        color = Color.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )
}
