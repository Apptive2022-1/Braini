package com.apptive.braini.presentation.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.braini.domain.IntentSenderLauncher
import com.apptive.braini.domain.log
import com.apptive.braini.domain.model.Account
import com.apptive.braini.domain.utils.AccountManager
import com.apptive.braini.domain.utils.GoogleOneTap
import com.apptive.braini.domain.utils.KakaoLogin
import com.apptive.braini.presentation.viewmodel.interfaces.ILoginViewModel
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountManager: AccountManager,
    private val googleSignIn: GoogleOneTap
): ViewModel(), ILoginViewModel {
    override val accountId: MutableState<String> = mutableStateOf("")
    override val accountPw: MutableState<String> = mutableStateOf("")
    private val _account = mutableStateOf(accountManager.currentAccount)
    val account: State<Account> get() = _account

    override fun isLoggedIn(): Boolean = accountManager.isLoggedIn()

    override fun loginWithKakao(context: Context, navigate: () -> Unit) {
        KakaoLogin.login(context) { account ->
            accountManager.login(account)
            navigate()
        }
    }

    override fun googleResultListener(result: ActivityResult, navigate: () -> Unit) {
        googleSignIn.onActicityResult(
            result = result,
            onSuccess = {
                accountManager.login(it)
                navigate()
            }
        )
    }

    override fun googleSignIn(launcher: IntentSenderLauncher) {
        googleSignIn.beginSignIn(launcher = launcher)
    }
}