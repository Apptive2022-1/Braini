package com.apptive.braini.presentation.view

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
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
import androidx.navigation.NavController
import com.apptive.braini.ui.theme.Blue800
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.ILoginViewModel
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel
import com.apptive.braini.presentation.viewmodel.mock.RoomCreateViewModelMock
import androidx.compose.foundation.layout.Row
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.apptive.braini.presentation.height
import com.apptive.braini.presentation.utils.ScreenUtils
import com.apptive.braini.presentation.viewmodel.RoomCreateViewModel
import com.apptive.braini.presentation.width
import com.chargemap.compose.numberpicker.AMPMHours
import com.chargemap.compose.numberpicker.Hours
import com.chargemap.compose.numberpicker.HoursNumberPicker
import com.chargemap.compose.numberpicker.NumberPicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.abs

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoomCreateScreen(
    roomCreateViewMode: IRoomCreateViewModel = RoomCreateViewModelMock()
) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    // Trailing Lambda
    TimePickerBottomSheet(
        viewModel = roomCreateViewMode,
        sheetState = sheetState
    ){
        RoomCreateContent {
            Title()
            RoomName(roomCreateViewMode)
            Number(roomCreateViewMode)
            Date(roomCreateViewMode)
            Time(
                sheetState = sheetState,
                viewModel = roomCreateViewMode
            )
            Calling(roomCreateViewMode)
            Lock(roomCreateViewMode)
            BrainiCompleteButton(roomCreateViewMode)
        }
    }
}

@Composable
private fun RoomCreateContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .width(86)
            .height(84)
//            .padding(horizontal = 26.dp, vertical = 42.dp)
            .wrapContentSize(Alignment.Center)
            .verticalScroll(rememberScrollState()),
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
        .width(85)
        .height(5)
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
        .width(85)
        .height(5)
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
        .width(85)
        .height(5)
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
            modifier = modifier.width(41),
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
        Spacer(modifier = Modifier.width(3))

        BrainiButton(
            modifier = modifier.width(41),
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
        .width(85)
        .height(5)
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

    Spacer(modifier = Modifier.height(5))
}

@Composable
private fun RoomName(
    roomSelectViewMode: IRoomCreateViewModel
){
    val text = roomSelectViewMode.roomTitle
    Row(){
        Text(
            text = "프로젝트명",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(63))
    }

    BrainiTextButton{
        BasicTextField(
            value = text.value,
            onValueChange = { newText ->
                
                text.value = newText
            },
            singleLine = true)
    }

    Spacer(modifier = Modifier.height(4))
}

@Composable
private fun Number(
    roomCreateViewMode: IRoomCreateViewModel
) {
    var text = roomCreateViewMode.roomNumber
    Row(){
        Text(
            text = "참여인원",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(66))

    }
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
    Spacer(modifier = Modifier.height(4))
}

//@Composable
//private fun Date(){
//    Row(){
//        Text(
//            text = "시작 날짜",
//            color = Color.Black,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.SemiBold
//        )
//        Spacer(modifier = Modifier.width(66))
//    }
//
//    BrainiDragButton()
//
//    Spacer(modifier = Modifier.height(4))
//}

@Composable
private fun Date(
    roomCreateViewMode: IRoomCreateViewModel
) {
    var text = roomCreateViewMode.roomDate
    Row(){
        Text(
            text = "시작 날짜",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(66))

    }
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
    Spacer(modifier = Modifier.height(4))
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Time(

    viewModel: IRoomCreateViewModel,
    sheetState: ModalBottomSheetState
){
    val hour = viewModel.hour
    val minute = viewModel.minute
    val daytime = viewModel.AMPM
    val coroutineScope = rememberCoroutineScope()
    var hourString = " 시   "
    var minuteString = " 분   "

    Row(){
        Text(
            text = "시작 시간",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(66))
    }

    BrainiDragButton(
        content = {
            BasicTextField(
                value = hour.value.toString() + hourString + minute.value.toString() + minuteString + daytime.value.toString(),
                onValueChange = { newText ->
                    hour.value = newText.toInt()
                    minute.value = newText.toInt()
                },
                readOnly = true,
                singleLine = true,
                textStyle = TextStyle(textAlign = TextAlign.Center)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    },
            ) {}
        }
    )

    Spacer(modifier = Modifier.height(4))
}

@Composable
private fun Calling(
    roomSelectViewMode: IRoomCreateViewModel
){
    var selected = roomSelectViewMode.callable

    Row(){
        Text(
            text = "음성 통화",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(66))
    }

    BrainiDividedButton(
        leftText = "O",
        rightText = "X",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
    Spacer(modifier = Modifier.height(4))
}

@Composable
private fun Lock(
    roomSelectViewMode: IRoomCreateViewModel
){
    var selected = roomSelectViewMode.isPublic

    Row(){
        Text(
            text = "공개 여부",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
            )
        Spacer(modifier = Modifier.width(66))
    }
    BrainiDividedButton(
        leftText = "O",
        rightText = "X",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
    Spacer(modifier = Modifier.height(5))
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TimePickerBottomSheet(
    viewModel: IRoomCreateViewModel,
    sheetState: ModalBottomSheetState,
    content: @Composable () -> Unit
){
    ModalBottomSheetLayout(
        sheetContent = {
            Box(modifier = Modifier
                .width(90)
                .height(70)
                .background(Color.White),
            contentAlignment = Alignment.Center){
                var pickerValue by remember { mutableStateOf<Hours>(AMPMHours(9, 12, AMPMHours.DayTime.PM ))
                }
                HoursNumberPicker(
                    dividersColor = Color.Transparent,
                    value = pickerValue,
                    onValueChange = { time ->
                        val ampmHours = time as AMPMHours
                        pickerValue = time
                        viewModel.hour.value = time.hours
                        viewModel.minute.value = time.minutes
                        viewModel.AMPM.value = ampmHours.dayTime
                    },
                    hoursDivider = {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            textAlign = TextAlign.Center,
                            text = "시"
                        )
                    },
                    minutesDivider = {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            textAlign = TextAlign.Center,
                            text = "분"
                        )
                    }
                )
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
        content = content
    )
}


@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {}
    RoomCreateScreen()
}