package com.example.braini.presentation.viewmodel.mock

import androidx.activity.result.ActivityResult
import com.example.braini.domain.IntentSenderLauncher
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import kotlin.random.Random

class LoginViewModelMock: ILoginViewModel {
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