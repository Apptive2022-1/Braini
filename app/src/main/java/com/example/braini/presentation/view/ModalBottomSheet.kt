package com.example.braini.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.braini.presentation.view.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet() {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetContent = {
            modallogin()
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(30.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )) {
            header()
            Clouds()
            Description()
            Buttons(
                onClick = {
                    coroutineScope.launch {
                        sheetState.show()
                    }
                }
            )
        }
    }
}



