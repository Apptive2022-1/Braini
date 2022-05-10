package com.example.braini.presentation.viewmodel.interfaces

import androidx.activity.result.ActivityResult
import com.example.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    fun isLoggedIn(): Boolean
    fun googleResultListener(result: ActivityResult, onSuccess: () -> Unit = {})
    fun googleSignIn(launcher: IntentSenderLauncher)
}