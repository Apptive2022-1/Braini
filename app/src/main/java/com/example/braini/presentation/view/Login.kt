package com.apptive.braini.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R
import com.example.braini._constant.UIConstant

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            Spacer(modifier = Modifier.height(50.dp))


            Text(text = "Linkit",
                fontSize = 50.sp
                )

            Text(text = "로그인")

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.width(UIConstant.BUTTON_WIDTH_LONG),
                onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.random_image_01),
                      contentDescription = null,
                      modifier = Modifier
                          .size(30.dp)
                          .clip(CircleShape))
                Spacer(modifier = Modifier.width(15.dp))
                Text(text="구글 계정으로 로그인")
            }
            
            Spacer(modifier = Modifier.height(10.dp))
            
            Button(
                modifier = Modifier.width(UIConstant.BUTTON_WIDTH_LONG),
                onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.random_image_02),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape))
                Spacer(modifier = Modifier.width(15.dp))
                Text("네이버 계정으로 로그인")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.width(UIConstant.BUTTON_WIDTH_LONG),
                onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.random_image_03),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape))
                Spacer(modifier = Modifier.width(15.dp))
                Text("카카오 계정으로 로그인")
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(onClick = { /*TODO*/ }) {
                Text("로그인 건너뛰기>",
                    fontSize = 10.sp)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}