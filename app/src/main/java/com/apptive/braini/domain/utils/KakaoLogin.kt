package com.apptive.braini.domain.utils

import android.content.Context
import android.widget.Toast
import com.apptive.braini.domain.log
import com.apptive.braini.domain.model.Account
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.*
import com.kakao.sdk.user.UserApiClient

/** 카카오 로그인을 활용하는 클래스 */
object KakaoLogin {

    fun login(context: Context, onSuccess: (Account) -> Unit) {
        // 토큰이 유효한지 체크한다.
        tryLoginWithKakaoToken(
            callLoginApi = {
                callKakaoLoginApi(context, onSuccess)
            },
            onSuccess = {
                loginWithCachedAccount(onSuccess)
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

    private fun callKakaoLoginApi(context: Context, onSuccess: (Account) -> Unit) {
        // 이곳에서 사용하는 accessToken은 REST API에 이용된다.
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) handleError(context, error)
            else if (token != null) loginWithCachedAccount(onSuccess)
        }
    }

    private fun loginWithCachedAccount(onSuccess: (Account) -> Unit) {
        UserApiClient.instance.me { user, error ->
            val id = user?.id ?: 0L
            val email = user?.kakaoAccount?.email ?: ""
            val name = user?.kakaoAccount?.profile?.nickname ?: ""

            val account = Account(
                id = id.toString(),
                email = email,
                name = name
            )
            onSuccess(account)
        }
    }

    private fun handleError(context: Context, error: Throwable?) {
        "로그인 실패 $error".log()
        if (error is ClientError)   handleClientError(context, error)
        if (error is AuthError)     handleAuthError(context, error)
    }

    private fun handleClientError(context: Context, error: ClientError) {
        when(error.reason) {
            ClientErrorCause.NotSupported -> {
                Toast.makeText(context, "카카오톡이 설치되지 않았습니다.", Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
    }

    private fun handleAuthError(context: Context, error: AuthError) {
        if (error.response.error == "NotSupportError") {
            Toast.makeText(context, "먼저 카카오톡에서 로그인해주세요.", Toast.LENGTH_LONG).show()
        }
    }
}