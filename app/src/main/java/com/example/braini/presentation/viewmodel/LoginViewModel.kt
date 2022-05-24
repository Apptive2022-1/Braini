package com.example.braini.presentation.viewmodel

import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.braini.domain.IntentSenderLauncher
import com.example.braini.domain.model.Account
import com.example.braini.domain.utils.AccountManager
import com.example.braini.domain.utils.GoogleOneTap
import com.example.braini.presentation.viewmodel.interfaces.ILoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountManager: AccountManager,
    private val googleSignIn: GoogleOneTap
): ViewModel(), ILoginViewModel {
    private val _account = mutableStateOf(accountManager.currentAccount)
    val account: State<Account> get() = _account
    override var accountId: MutableState<String> = mutableStateOf("")
    override var accountPw: MutableState<String> = mutableStateOf("")

    override fun isLoggedIn(): Boolean = accountManager.isLoggedIn()

    override fun googleResultListener(result: ActivityResult, onSuccess: () -> Unit) {
        googleSignIn.onActicityResult(result = result, onSuccess = onSuccess)
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        googleSignIn.beginSignIn(launcher = launcher)
    }
}