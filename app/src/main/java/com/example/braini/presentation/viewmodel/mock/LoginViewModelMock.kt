package com.example.braini.presentation.viewmodel.mock

import androidx.activity.result.ActivityResult
import com.example.braini.domain.IntentSenderLauncher
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel

class LoginViewModelMock: ILoginViewModel {
    override fun googleResultListener(result: ActivityResult) {
        TODO("Not yet implemented")
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        TODO("Not yet implemented")
    }

}