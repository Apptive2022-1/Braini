package com.apptive.braini.presentation.viewmodel.interfaces

import android.content.Context
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    val accountId: MutableState<String>
    val accountPw: MutableState<String>

    fun isLoggedIn(): Boolean
    fun loginWithKakao(context: Context, navigate: () -> Unit)
    fun googleResultListener(result: ActivityResult, navigate: () -> Unit = {})
    fun googleSignIn(launcher: IntentSenderLauncher)
}