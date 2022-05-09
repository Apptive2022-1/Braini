package com.apptive.braini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.apptive.braini.ui.theme.LayoutPracticeTheme
import com.apptive.braini.view.LoginScreen
import com.example.braini.presentation.navigation.SetupNavGraph
import com.example.braini.presentation.view.ModalBottomSheet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutPracticeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
                ModalBottomSheet()
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