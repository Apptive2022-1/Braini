package com.apptive.braini.presentation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.apptive.braini.presentation.model.Size
import com.apptive.braini.presentation.utils.ScreenUtils

@Composable
fun requireContext(): Context = LocalContext.current

fun Context.getActivity() = this as ComponentActivity

fun Modifier.size(size: Size) = this.then(
    Modifier
        .width(size.width)
        .height(size.height)
)

// mixin : 메소드를 외부에서 정의하는 방식
// 컴포저블의 높이를 휴대폰 화면의 비율(percent: Int)로 설정한다.
fun Modifier.height(percent: Int): Modifier = composed {
    this.then(Modifier.height(ScreenUtils.height(percent)))
}

fun Modifier.width(percent: Int): Modifier = composed {
    this.then(Modifier.width(ScreenUtils.width(percent)))
}

fun NavController.popNavigate(route: String) {
    this.popBackStack()
    this.navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}