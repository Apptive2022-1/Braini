package com.apptive.braini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.apptive.braini.domain.log
import com.apptive.braini.presentation.navigation.SetupNavGraph
import com.apptive.braini.presentation.view.Main.MemoTypeSelectScreen
import com.apptive.braini.presentation.view.MemoCreate
import com.apptive.braini.presentation.view.RoomCreateScreen
import com.apptive.braini.presentation.viewmodel.RoomCreateViewModel
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutPracticeTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
                val viewModel = hiltViewModel<RoomCreateViewModel>()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutPracticeTheme {
        Greeting("Android")
    }
}