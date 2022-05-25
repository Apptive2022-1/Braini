package com.apptive.braini.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.braini.presentation.view.RoomCreate.CreateBox
import com.apptive.braini.presentation.view.RoomCreate.Header
import com.apptive.braini.presentation.view.RoomCreate.PastRecord
import com.apptive.braini.ui.theme.LayoutPracticeTheme


@Composable
fun RoomCreateScreen(navController: NavController) {
    RoomCreateContent {
        Header()
        CreateBox(navController)
        PastRecord()
    }
}

@Composable
private fun RoomCreateContent(
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

@Preview(showSystemUi = true)
@Composable
private fun RoomCreateScreenPreview() {
    LayoutPracticeTheme() {
        RoomCreateScreen(rememberNavController())
    }
}