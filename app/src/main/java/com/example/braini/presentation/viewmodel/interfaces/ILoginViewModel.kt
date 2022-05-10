package com.example.braini.presentation.viewmodel.interfaces

import androidx.activity.result.ActivityResult
import com.example.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    fun googleResultListener(result: ActivityResult)
    fun googleSignIn(launcher: IntentSenderLauncher)
}