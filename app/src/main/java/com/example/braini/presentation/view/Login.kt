package com.apptive.braini.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.braini.R
import com.example.braini.presentation.navigation.Screen
import com.example.braini.presentation.popAndNavigate
import com.example.braini.presentation.viewmodel.LoginViewModel
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import com.example.braini.presentation.viewmodel.mock.LoginViewModelMock
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(
    viewModel: ILoginViewModel = LoginViewModelMock(),
    navController: NavController
){
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheet(
        viewModel = viewModel,
        navController = navController,
        sheetState = sheetState
    ) {
        LoginBackground {
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

@Composable
private fun LoginBackground(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        content = content
    )
}

@Composable
public fun ColumnScope.header()
{
    Text(
        modifier = Modifier
        .width(230.dp)
        .weight(0.9f)
        .padding(20.dp)
        .padding(top = 40.dp),
        text = "HELLO!",
        fontSize = 43.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
public fun ColumnScope.Clouds(){
    Box(
        modifier = Modifier
            .weight(2f)
            .padding(top = 50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.people),
            contentDescription = null,
            modifier = Modifier.size(350.dp)
        )
    }
}

@Composable
public fun ColumnScope.Description(){
    Box(modifier = Modifier.weight(1f))
    {
        Column(modifier = Modifier.padding(top = 60.dp))
        {
            Text(
                "'Braini'는",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,),
                color = Color.Black,
                fontSize = 23.sp,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp,),
                color = Color.Black,
                fontSize = 23.sp,
                text = "여러분의 아이디어를 응원합니다"
            )

        }
    }
}


@Composable
public fun ColumnScope.Buttons(onClick: () -> Unit){
    Box(modifier = Modifier.weight(1f))
    {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onClick,
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffc9e4fd)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                    text = stringResource(R.string.login_button),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffc9e4fd)),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                    text = stringResource(R.string.new_user_button),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ModalBottomSheet(
    viewModel: ILoginViewModel,
    navController: NavController,
    sheetState: ModalBottomSheetState,
    content: @Composable () -> Unit
){
    var idtext by remember { mutableStateOf("")}
    var pwtext by remember { mutableStateOf("")}
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            viewModel.googleResultListener(
                result = result,
                onSuccess = {
                    navController.popAndNavigate(Screen.RoomCreate.route)
                }
            )
        }
    )

    ModalBottomSheetLayout(
        sheetContent = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(430.dp)
                .background(Color.White)){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier
                        .width(200.dp)
                        .height(8.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xffC4C4C4)))
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "SNS 계정으로 로그인",
                    fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .width(350.dp),
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(Color(0xfffbe300)),
                        onClick = { /*TODO*/ }) {
                        Image(modifier = Modifier.size(30.dp)
                            .weight(2f),
                            painter = painterResource(id = R.drawable.kakao),
                            contentDescription = null)
                        Text(modifier = Modifier.weight(10f)
                            .padding(start = 35.dp),
                            text = "카카오톡으로 시작하기")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(modifier = Modifier
                        .width(350.dp),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        onClick = { /*TODO*/ }) {
                        Image(modifier = Modifier.size(30.dp)
                            .weight(2f),
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = null )
                        Text(modifier = Modifier.weight(10f)
                            .padding(start = 53.dp),
                            text = "구글로 시작하기")
                    }
                    Text(
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                        text = "또는"
                    )
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .border(width = 1.dp, color = Color(0xff345BC0), shape = RoundedCornerShape(30))
                            .clip(RoundedCornerShape(30))
                            .height(45.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(2f),
                                text = "아이디",
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(2.5.dp)
                                    .height(35.dp)
                                    .background(Color(0xff345BC0))
                            )
                            var textId by viewModel.accountId
                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(7f)
                                    .padding(start = 10.dp),
                                value = textId,
                                onValueChange = {newText ->
                                    textId = newText
                                },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(
                                    imeAction = ImeAction.Next
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .border(width = 1.dp, color = Color(0xff345BC0), shape = RoundedCornerShape(30))
                            .clip(RoundedCornerShape(30))
                            .height(45.dp),
                        Alignment.Center
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(2f),
                                text = "비밀번호",
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(2.5.dp)
                                    .height(35.dp)
                                    .background(Color(0xff345BC0))
                            )
                            var textPw by viewModel.accountPw
                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(7f)
                                    .padding(start = 10.dp),
                                value = textPw,
                                onValueChange = {newText ->
                                    textPw = newText},
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    Button(
                        modifier = Modifier
                            .width(350.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xff345BC0)),
                        shape = RoundedCornerShape(30),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            color = Color.White,
                            text = "로그인")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    ClickableText(
                        text = AnnotatedString("아이디/비밀번호 찾기"),
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        onClick ={}
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        },
        sheetState = sheetState,
        sheetBackgroundColor = Color.White,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
        content = content
    )

}


@Preview
@Composable
fun BPreview(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}