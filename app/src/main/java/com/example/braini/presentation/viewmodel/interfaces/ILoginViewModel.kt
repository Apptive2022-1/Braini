package com.example.braini.presentation.viewmodel.interfaces

import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import com.example.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    var accountId: MutableState<String>
    var accountPw: MutableState<String>

    fun isLoggedIn(): Boolean
    fun googleResultListener(result: ActivityResult, onSuccess: () -> Unit = {})
    fun googleSignIn(launcher: IntentSenderLauncher)
}