package com.apptive.braini.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.braini.R

@Composable
fun LoginScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(listOf(Color(55, 103, 706), Color(143, 171, 217))),
            shape = RectangleShape
        )) {
        header()
        Clouds()
        Description()
        Buttons()
    }
}

@Composable
private fun ColumnScope.header()
{
    Text(modifier = Modifier
        .width(200.dp)
        .weight(0.7f)
        .padding(20.dp)
        .padding(top = 20.dp),
        text = "Hello!",
        fontSize = 50.sp,
        color = Color.White,
        textAlign = TextAlign.Center)
}

@Composable
private fun ColumnScope.Clouds(){
    Box(modifier = Modifier
        .weight(2f)
        .padding(top = 50.dp)){
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 260.dp)){
            Image(painter = painterResource(id = R.drawable.small_cloud),
                contentDescription = null,
                modifier = Modifier.size(100.dp))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 20.dp)){
            Image(painter = painterResource(id = R.drawable.middle_cloud),
                contentDescription = null,
                modifier = Modifier.size(150.dp))
            Image(painter = painterResource(id = R.drawable.middle_cloud_line),
                contentDescription = null,
                modifier = Modifier.size(150.dp))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp, start = 160.dp)){
            Image(painter = painterResource(id = R.drawable.large_cloud),
                contentDescription = null,
                modifier = Modifier.size(200.dp))
            Image(painter = painterResource(id = R.drawable.large_cloud_line),
                contentDescription = null,
                modifier = Modifier.size(200.dp))
        }
    }
}

@Composable
private fun ColumnScope.Description(){
    Box(modifier = Modifier.weight(1f)){
        Column(modifier = Modifier.padding(top = 40.dp)) {
            Text("'Braini'는",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,),
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
            )
            Text( modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp,),
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                text = "여러분의 아이디어를 응원합니다"
            )

        }
    }
}


@Composable
private fun ColumnScope.Buttons(){
    Box(modifier = Modifier.weight(1f)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = stringResource(R.string.login_button),
                    textAlign = TextAlign.Center,
                    color = Color(55, 103, 706),
                    fontWeight = FontWeight.Bold)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(15.dp)) {
                Text(text = stringResource(R.string.new_user_button),
                    textAlign = TextAlign.Center,
                    color = Color(55,103,706),
                    fontWeight = FontWeight.Bold)

            }
        }
    }
}

@Preview
@Composable
fun BPreview(){
    LoginScreen()
}