package com.example.layoutpractice.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "LinkIt")
        Button(onClick = { /*TODO*/ }) {
            Text("구글로 로그인")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("네이버로 로그인")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("카카오로 로그인")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text("로그인 건너뛰기")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}