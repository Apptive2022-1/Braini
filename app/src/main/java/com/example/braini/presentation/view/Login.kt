package com.apptive.braini.presentation.view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.apptive.braini.R
import com.example.braini.presentation.navigation.Screen
import com.example.braini.presentation.popAndNavigate
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import com.example.braini.presentation.viewmodel.mock.LoginViewModelMock

@Composable
fun LoginScreen(
    viewModel: ILoginViewModel = LoginViewModelMock(),
    navController: NavController
){
    LoginBackground {
        Header()
        Clouds()
        Description()
        Buttons(viewModel = viewModel, navController = navController)
    }
}

@Composable
private fun LoginBackground(
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(listOf(Color(55, 103, 706), Color(143, 171, 217))),
                shape = RectangleShape
            ),
        content = content
    )
}

@Composable
private fun ColumnScope.Header()
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
private fun ColumnScope.Clouds(){
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
private fun ColumnScope.Description(){
    Box(
        modifier = Modifier.weight(1f)
    ){
        Column(
            modifier = Modifier.padding(top = 40.dp)
        ) {
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
private fun ColumnScope.Buttons(){
    Box(modifier = Modifier.weight(1f)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {},
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



@Preview
@Composable
fun BPreview(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}