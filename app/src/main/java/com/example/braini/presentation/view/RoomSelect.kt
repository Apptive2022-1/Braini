package com.apptive.braini.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.ui.theme.Blue500
import com.apptive.braini.ui.theme.Blue700
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.example.braini.Side

@Composable
fun RoomSelectScreen() {
    RoomSelectContent(){
        Title()
        RoomName()
        Number()
        Date()
        Time()
        Calling()
        Lock()
    }
}

@Composable
private fun RoomSelectContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}


@Composable
private fun BrainiButton(
    modifier: Modifier = Modifier,
    color: Color = Blue700,
    content: @Composable BoxScope.()->Unit = {}
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(36.dp)
        .clip(RoundedCornerShape(30))
        .background(color),
        content = content
    )
}

@Composable
private fun BrainiDividedButton(
    modifier: Modifier = Modifier,
    side: Side,
    color: Color = Blue500,
    leftText: String = "",
    rightText: String = ""
) {
    BrainiButton(color = color) {
        Row(Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                if (side == Side.LEFT) {
                    BrainiButton(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(30)),
                        color = Blue700,
                    )
                }
                Text(
                    modifier = Modifier,
                    text = leftText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                if (side == Side.RIGHT) {
                    BrainiButton(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(30)),
                        color = Blue700
                    )
                }
                Text(
                    modifier = Modifier,
                    text = rightText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
@Composable
private fun Title(){
        Text(
            text = "방 옵션 선택",
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(78.dp))
    }

@Composable
private fun RoomName(){
    Text(
        text = "프로젝트명",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 260.dp)
    )

    BrainiButton()

    Spacer(modifier = Modifier.height(60.dp))
}

@Composable
private fun Number() {
    BrainiDividedButton(
        side = Side.RIGHT,
        leftText = "참여인원",
        rightText = "6"
    )

    Spacer(modifier = Modifier.height(37.dp))
}

@Composable
private fun Date(){
    Text(
        text = "시작 날짜",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 260.dp)
    )

    BrainiButton()

    Spacer(modifier = Modifier.height(37.dp))
}

@Composable
private fun Time(){
    Text(
        text = "시작 시간",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 260.dp)
    )

    BrainiButton()

    Spacer(modifier = Modifier.height(37.dp))
}

@Composable
private fun Calling(){
    Text(
        text = "음성 통화",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 260.dp)
    )

    BrainiDividedButton(
        side = Side.LEFT,
        leftText = "사용 O",
        rightText = "사용 X"
    )

    Spacer(modifier = Modifier.height(37.dp))
}

@Composable
private fun Lock(){
    Text(
        text = "공개 여부",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 260.dp)
    )

    BrainiDividedButton(
        side = Side.LEFT,
        leftText = "사용 O",
        rightText = "사용 X"
    )
}

@Preview(showSystemUi = true, name = "RoomSelectPreview")
@Composable
private fun RoomSelectScreenPreview() {
    LayoutPracticeTheme() {
        
    }
    RoomSelectScreen()
}