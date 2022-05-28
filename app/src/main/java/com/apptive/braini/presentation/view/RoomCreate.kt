package com.apptive.braini.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.ui.theme.Blue800
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel
import com.apptive.braini.presentation.viewmodel.mock.RoomCreateViewModelMock

@Composable
fun RoomCreateScreen(
    roomCreateViewMode: IRoomCreateViewModel = RoomCreateViewModelMock()
) {
    RoomCreateContent {
        Title()
        RoomName(roomCreateViewMode)
        Number(roomCreateViewMode)
        Date()
        Time()
        Calling(roomCreateViewMode)
        Lock(roomCreateViewMode)
        BrainiCompleteButton(roomCreateViewMode)
    }
}

@Composable
private fun RoomCreateContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 38.dp, vertical = 75.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
private fun BrainiTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.()->Unit = {}
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(36.dp)
        .clip(RoundedCornerShape(40))
        .background(
            brush = Brush.horizontalGradient(listOf(Color(188, 195, 254), Color(201, 228, 253)))
        )
        .clickable { onClick() },
        content = content,
        contentAlignment = Alignment.Center
    )
}

@Composable
private fun BrainiDragButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.()->Unit = {}
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(36.dp)
        .clip(RoundedCornerShape(40))
        .background(
            brush = Brush.horizontalGradient(listOf(Color(188, 195, 254), Color(201, 228, 253)))
        )
        .clickable { onClick() },
        content = content,
        contentAlignment = Alignment.Center
    )
}

@Composable
private fun BrainiButton(
    modifier: Modifier = Modifier,
    selected: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.()->Unit = {}
){
    // 선택되지 않았을 경우 투명도 주기
    val alpha = if (selected) 1f else 0.5f
    val alphaInt = if (selected) 255 else 100
    val border = if (selected) Blue800 else Color.White

    Box(modifier = modifier
        .fillMaxWidth()
        .height(36.dp)
        .clip(RoundedCornerShape(40))
        .background(
            brush = Brush.horizontalGradient(
                listOf(
                    Color(188, 195, 254, alphaInt),
                    Color(201, 228, 253, alphaInt)
                )
            )
        )
        .border(width = 1.dp, shape = RoundedCornerShape(40), color = border)
        .alpha(alpha)
        .clickable { onClick() },
        content = content,
        contentAlignment = Alignment.Center
    )
}


@Composable
private fun BrainiDividedButton(
    modifier: Modifier = Modifier,
    leftText: String = "",
    rightText: String = "",
    leftOnClick: () -> Unit = {},
    rightOnClick: () -> Unit = {},
    selected: Side = Side.LEFT
){
    Row(){
        BrainiButton(
            modifier = modifier.width(151.dp),
            selected = (selected == Side.LEFT),
            onClick = leftOnClick
        )
        {
            Text(
                text = leftText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Spacer(modifier = Modifier.width(13.dp))

        BrainiButton(
            modifier = modifier.width(151.dp),
            selected = (selected == Side.RIGHT),
            onClick = rightOnClick
        ){
            Text(
                text = rightText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun BrainiCompleteButton(
    viewModel: IRoomCreateViewModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.()->Unit = {}
){
    Box(modifier = modifier
        .fillMaxWidth()
        .height(36.dp)
        .clip(RoundedCornerShape(40))
        .background(color = Color.White)
        .border(width = 1.dp, shape = RoundedCornerShape(40), color = Blue800),
        contentAlignment = Alignment.Center
    ) {
        TextButton(
            modifier = Modifier.fillMaxSize(),
            onClick = onClick,
            enabled = viewModel.isFilled
        ) {
            Text(text = "완료")
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

    Spacer(modifier = Modifier.height(39.dp))
}

@Composable
private fun RoomName(
    roomSelectViewMode: IRoomCreateViewModel
){
    val text = roomSelectViewMode.roomTitle

    Text(
        text = "프로젝트명",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 240.dp)
    )

    BrainiTextButton{
        BasicTextField(
            value = text.value,
            onValueChange = { newText ->
                text.value = newText
            },
            singleLine = true)
    }

    Spacer(modifier = Modifier.height(34.dp))
}

@Composable
private fun Number(
    roomSelectViewMode: IRoomCreateViewModel
) {
    var text = roomSelectViewMode.roomNumber
    Text(
        text = "참여인원",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 250.dp)
    )
    BrainiTextButton{
        BasicTextField(
            value = text.value.toString(),
            onValueChange = { newText ->
                text.value = newText.toInt()
            },
            singleLine = true,
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )
    }
    Spacer(modifier = Modifier.height(34.dp))
}

@Composable
private fun Date(){
    Text(
        text = "시작 날짜",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 250.dp)
    )

    BrainiDragButton()

    Spacer(modifier = Modifier.height(34.dp))
}

@Composable
private fun Time(){
    Text(
        text = "시작 시간",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 250.dp)
    )

    BrainiDragButton()

    Spacer(modifier = Modifier.height(34.dp))
}

@Composable
private fun Calling(
    roomSelectViewMode: IRoomCreateViewModel
){
    var selected = roomSelectViewMode.callable

    Text(
        text = "음성 통화",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 250.dp)
    )
    BrainiDividedButton(
        leftText = "사용 O",
        rightText = "사용 X",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
    Spacer(modifier = Modifier.height(34.dp))
}

@Composable
private fun Lock(
    roomSelectViewMode: IRoomCreateViewModel
){
    var selected = roomSelectViewMode.isPublic

    Text(
        text = "공개 여부",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(end = 250.dp)
    )
    BrainiDividedButton(
        leftText = "사용 O",
        rightText = "사용 X",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
}


@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {}
    RoomCreateScreen()
}