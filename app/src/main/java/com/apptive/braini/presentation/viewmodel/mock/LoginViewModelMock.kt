package com.apptive.braini.presentation.viewmodel.mock

import android.content.Context
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini.domain.IntentSenderLauncher
import com.apptive.braini.presentation.viewmodel.interfaces.ILoginViewModel
import kotlin.random.Random

class LoginViewModelMock: ILoginViewModel {
    override val accountId: MutableState<String> = mutableStateOf("")
    override val accountPw: MutableState<String> = mutableStateOf("")

    override fun isLoggedIn(): Boolean {
        return Random.nextBoolean()
    }

    override fun loginWithKakao(context: Context, navigate: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun googleResultListener(result: ActivityResult, navigate: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        TODO("Not yet implemented")
    }

}