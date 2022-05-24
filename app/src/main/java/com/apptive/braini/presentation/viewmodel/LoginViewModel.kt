package com.apptive.braini.presentation.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.braini.domain.IntentSenderLauncher
import com.apptive.braini.domain.log
import com.apptive.braini.domain.model.Account
import com.apptive.braini.domain.utils.AccountManager
import com.apptive.braini.domain.utils.GoogleOneTap
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
    private val _account = mutableStateOf(accountManager.currentAccount)
    val account: State<Account> get() = _account

    override fun isLoggedIn(): Boolean = accountManager.isLoggedIn()

    override fun loginWithKakao(context: Context, navigate: () -> Unit) {
        // 토큰이 유효한지 체크한다.
        tryLoginWithKakaoToken(
            callLoginApi = {
                callKakaoLoginApi(context, navigate)
            },
            onSuccess = {
                loginWithCachedKakaoAccount(navigate)
            },
        )
    }

    private fun tryLoginWithKakaoToken(
        onSuccess: () -> Unit,
        callLoginApi: () -> Unit,
    ) {
        if (!AuthApiClient.instance.hasToken()) return callLoginApi()

        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error == null) return@accessTokenInfo onSuccess()
            if (error is KakaoSdkError && error.isInvalidTokenError()) callLoginApi()

            // 기타 에러
            "카카오 로그인 에러! $error".log()
        }
    }

    private fun callKakaoLoginApi(context: Context, navigate: () -> Unit) {
        // 이곳에서 사용하는 accessToken은 REST API에 이용된다.
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) handleErrorWithKakao(context, error)
            else if (token != null) loginWithCachedKakaoAccount(navigate)
        }
    }

    private fun loginWithCachedKakaoAccount(navigate: () -> Unit) {
        UserApiClient.instance.me { user, error ->
            val id = user?.id ?: 0L
            val email = user?.kakaoAccount?.email ?: ""
            val name = user?.kakaoAccount?.profile?.nickname ?: ""

            val account = Account(
                id = id.toString(),
                email = email,
                name = name
            )
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

    private fun handleErrorWithKakao(context: Context, error: Throwable?) {
        "로그인 실패 $error".log()
        if (error is ClientError) handleClientErrorWithKakao(context, error)
    }

    private fun handleClientErrorWithKakao(context: Context, error: ClientError) {
        when(error.reason) {
            ClientErrorCause.NotSupported -> {
                Toast.makeText(context, "카카오톡이 설치되지 않았습니다.", Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
    }
}