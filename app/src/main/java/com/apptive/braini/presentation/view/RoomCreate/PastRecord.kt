package com.apptive.braini.presentation.view.RoomCreate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.presentation.model.Size
import com.apptive.braini.presentation.size

@Composable
fun ColumnScope.PastRecord(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "과거 브레인스토밍",
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(8.dp))
    Column(Modifier.padding(horizontal = 10.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PastRecordBox()
            PastRecordBox()
            PastRecordBox()
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PastRecordBox()
            PastRecordBox()
            PastRecordBox()
        }
    }
}

@Composable
private fun PastRecordBox(
    size: Size = Size(100.dp),
    bgColor: Color = Color.White
){
    Surface(
        shape = RoundedCornerShape(20),
        elevation = 10.dp
    ){
        Box(
            modifier = Modifier
                .size(size)
                .background(bgColor)
        )
    }
}

@Preview
@Composable
private fun PastRecordPreview() {
    Column {
        PastRecord()
    }
}