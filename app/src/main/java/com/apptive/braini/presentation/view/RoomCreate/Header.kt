package com.apptive.braini.presentation.view.RoomCreate

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColumnScope.Header() {
    Logo()
    GuideSentense()
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

@Preview
@Composable
private fun HeaderPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
    }
}