package com.example.braini.presentation.viewmodel.interfaces

import androidx.activity.result.ActivityResult
import com.example.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    fun onActivityResult(result: ActivityResult)
    fun beginSignIn(launcher: IntentSenderLauncher)
}