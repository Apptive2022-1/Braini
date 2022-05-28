package com.apptive.braini.presentation.view

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
import com.apptive.braini.ui.theme.LayoutPracticeTheme


@Composable
fun MainScreen() {
    MainContent {
        Logo()
        GuideSentense()
        CreateBox()
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
            .padding(horizontal = 25.dp, vertical = 45.dp)
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
    Spacer(modifier = Modifier.height(38.dp))
}

@Composable
private fun GuideSentense(
    modifier: Modifier = Modifier
){
    Text(
        modifier = modifier.fillMaxWidth(),
        text = "팀 프로젝트에 참여하세요 :)",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        modifier = modifier.fillMaxWidth(),
        text = "방을 만들어보세요",
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun CreateBox(){
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
                .padding(top = 15.dp),
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
            .padding( start = 15.dp, end = 10.dp)
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
                    .clickable {  },
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
private fun PastRecord(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "과거 브레인스토밍",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Column{
        Row {
            PastRecordBox()
            Spacer(modifier = Modifier.width(13.dp))
            PastRecordBox()
            Spacer(modifier = Modifier.width(13.dp))
            PastRecordBox()
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row{
            PastRecordBox()
            Spacer(modifier = Modifier.width(13.dp))
            PastRecordBox()
            Spacer(modifier = Modifier.width(13.dp))
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
            .width(100.dp)
            .height(99.dp)
            .clip(RoundedCornerShape(20))
            .background(Color.White)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {

    }
    MainScreen()
}