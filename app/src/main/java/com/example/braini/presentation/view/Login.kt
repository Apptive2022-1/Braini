package com.apptive.braini.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R
import com.example.braini.presentation.view.ModalBottomSheet

@Composable
fun LoginScreen(){
    ModalBottomSheet()
}

@Composable
public fun ColumnScope.header()
{
    Text(modifier = Modifier
        .width(230.dp)
        .weight(0.9f)
        .padding(20.dp)
        .padding(top = 20.dp),
        text = "HELLO!",
        fontSize = 50.sp,
        color = Color.Black,
        textAlign = TextAlign.Center)
}

@Composable
public fun ColumnScope.Clouds(){
    Box(modifier = Modifier
        .weight(2f)
        .padding(top = 50.dp)
        .fillMaxWidth(),
    contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.people),
            contentDescription = null,
        modifier = Modifier.size(350.dp))
    }
}

@Composable
public fun ColumnScope.Description(){
    Box(modifier = Modifier.weight(1f)){
        Column(modifier = Modifier.padding(top = 40.dp)) {
            Text("'Braini'는",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,),
                color = Color.Black,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
            )
            Text( modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp,),
                color = Color.Black,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                text = "여러분의 아이디어를 응원합니다"
            )

        }
    }
}


@Composable
public fun ColumnScope.Buttons(onClick: () -> Unit){
    Box(modifier = Modifier.weight(1f)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = onClick,
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffc9e4fd)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = stringResource(R.string.login_button),
                    textAlign = TextAlign.Center,
                    color = Color.Black)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffc9e4fd)),
                shape = RoundedCornerShape(15.dp)) {
                Text(text = stringResource(R.string.new_user_button),
                    textAlign = TextAlign.Center,
                    color = Color.Black)

            }
        }
    }
}


@Composable
fun modallogin(){
Box(modifier = Modifier
    .fillMaxWidth()
    .height(400.dp)
    .background(Color.White)){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(10.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.Gray))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "SNS 계정으로 로그인")
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier
            .width(350.dp)
            .clip(RoundedCornerShape(40)),
            colors = ButtonDefaults.buttonColors(Color.White),
            onClick = { /*TODO*/ }) {
            Image(modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.google),
                contentDescription = null )
            Text(text = "Google로 시작하기")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(modifier = Modifier
            .width(350.dp)
            .clip(RoundedCornerShape(40)),
            colors = ButtonDefaults.buttonColors(Color(0xfffbe300)),
            onClick = { /*TODO*/ }) {
            Image(modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.kakao),
                contentDescription = null)
            Text(text = "카카오톡으로 시작하기")
        }
        Text(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            text = "또는")

    }
}
}


@Preview
@Composable
fun BPreview(){
    modallogin()
}