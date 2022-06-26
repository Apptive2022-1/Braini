package com.apptive.braini.presentation.view

import android.content.Context
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
import com.apptive.braini.presentation.height
import com.apptive.braini.presentation.navigation.Screen
import com.apptive.braini.presentation.width
import com.apptive.braini.ui.theme.LayoutPracticeTheme


@Composable
fun MainScreen(
    navController: NavController
) {
    MainContent {
        Logo()
        GuideSentense()
        CreateBox(navController)
        PastRecord()
    }
}
@Composable
private fun MainContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(87)
            .height(92)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
private fun Logo(){
    Text(
        text = "BRAINI",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(5))
}

@Composable
private fun GuideSentense(
    modifier: Modifier = Modifier
){
    Row(){
        Spacer(modifier = Modifier.width(6))
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "팀 프로젝트에 참여하세요 :)",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
    Spacer(modifier = Modifier.height(1))
    Row(){
        Spacer(modifier = Modifier.width(6))
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "방을 만들어보세요",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
    Spacer(modifier = Modifier.height(2))
}

@Composable
private fun CreateBox(
    navController: NavController
){
    Surface(
        shape = RoundedCornerShape(20),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .width(88)
                .height(22)
                .background(
                    color = Color(221, 229, 255)
                )
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CodeBox()
            Spacer(modifier = Modifier.height(5))
            NewBox(navController)
        }
    }
    Spacer(modifier = Modifier.height(12))
}

@Composable
private fun CodeBox(){
    Box(
        modifier = Modifier
            .width(77)
            .height(4)
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
                    .width(12)
                    .height(3)
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

@Composable
private fun NewBox(
    navController: NavController
) {
    Column(){
        Text(
            text = "코드가 없다면 방을 새로 만들어보세요",
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp
        )
        Spacer(modifier = Modifier.height(1))
        Box(
            modifier = Modifier
                .width(77)
                .height(5)
                .clip(RoundedCornerShape(20))
                .background(Color.White)
                .clickable {
                    navController.navigate(route = Screen.RoomCreate.route)
                }
        ){
            Column(){
                Spacer(modifier = Modifier.height(1))
                Row(){
                    Spacer(modifier = Modifier.width(30))
                    Text(
                        text = "Click here!",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}


    @Composable
private fun PastRecord(){
    Row(){
        Spacer(modifier = Modifier.width(6))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "과거 브레인스토밍",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
    Spacer(modifier = Modifier.height(1))
    Column{
        Row {
            PastRecordBox()
            Spacer(modifier = Modifier.width(4))
            PastRecordBox()
            Spacer(modifier = Modifier.width(4))
            PastRecordBox()
        }
        Spacer(modifier = Modifier.height(4))
        Row{
            PastRecordBox()
            Spacer(modifier = Modifier.width(4))
            PastRecordBox()
            Spacer(modifier = Modifier.width(4))
            PastRecordBox()
        }
    }
}

@Composable
private fun PastRecordBox(){
    Surface(
        shape = RoundedCornerShape(20),
        elevation = 10.dp
    ){
        Box(modifier = Modifier
            .width(27)
            .height(13)
            .clip(RoundedCornerShape(20))
            .background(Color.White)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    val navController = rememberNavController()
    LayoutPracticeTheme() {}
    MainScreen(navController = navController)
}