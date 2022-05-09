package com.example.braini.presentation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun requireContext(): Context = LocalContext.current

fun Context.getActivity() = this as ComponentActivity