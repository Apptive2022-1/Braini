package com.apptive.braini.presentation.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.apptive.braini.presentation.height
import com.apptive.braini.presentation.view.Main.MemoTypeSelectScreen
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel
import com.apptive.braini.presentation.viewmodel.mock.RoomCreateViewModelMock
import com.apptive.braini.presentation.width

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MemoCreateScreen(

) {
    MemoCreateContent{
        MemoBackground()
    }
}
@Composable
private fun MemoCreateContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
private fun MemoBackground(){
    Box(modifier = Modifier
        .width(3000.dp)
        .height(3000.dp)
        .background(Color.White)
    )
}