package com.example.braini.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.braini.ui.theme.LayoutPracticeTheme

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
