package com.example.braini.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.braini.ui.theme.Blue700
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.apptive.braini.view.RoomSelectScreen

@Composable
fun RoomCreateScreen() {
    RoomCreateContent {

    }
}

@Composable
private fun RoomCreateContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 22.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {

    }
    RoomCreateScreen()
}
