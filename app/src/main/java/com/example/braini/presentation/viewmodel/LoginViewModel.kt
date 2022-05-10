package com.example.braini.presentation.viewmodel

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.braini.domain.IntentSenderLauncher
import com.example.braini.domain.utils.AccountManager
import com.example.braini.domain.utils.GoogleOneTap
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val oneTap: GoogleOneTap
): ViewModel(), ILoginViewModel {
    override fun googleResultListener(result: ActivityResult) {
        oneTap.onActicityResult(result)
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        oneTap.beginSignIn(launcher = launcher)
    }
}