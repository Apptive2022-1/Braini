package com.apptive.braini.presentation.viewmodel.interfaces

import android.content.Context
import androidx.activity.result.ActivityResult
import com.apptive.braini.domain.IntentSenderLauncher

interface ILoginViewModel {
    fun isLoggedIn(): Boolean
    fun loginWithKakao(context: Context, navigate: () -> Unit)
    fun googleResultListener(result: ActivityResult, navigate: () -> Unit = {})
    fun googleSignIn(launcher: IntentSenderLauncher)
}