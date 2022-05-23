package com.example.braini.presentation.viewmodel.mock

import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.braini.domain.IntentSenderLauncher
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import kotlin.random.Random

class LoginViewModelMock: ILoginViewModel {
    override var accountId: MutableState<String> = mutableStateOf("anything")
    override var accountPw: MutableState<String> = mutableStateOf("something")
    override fun isLoggedIn(): Boolean {
        return Random.nextBoolean()
    }

    override fun googleResultListener(result: ActivityResult, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        TODO("Not yet implemented")
    }

}