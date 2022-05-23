package com.apptive.braini.domain.utils

import android.app.Activity
import android.content.Context
import android.content.IntentSender
import android.content.IntentSender.SendIntentException
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import com.apptive.braini.R
import com.apptive.braini.MainApplication
import com.apptive.braini.domain.IntentSenderLauncher
import com.apptive.braini.domain.log
import com.apptive.braini.domain.model.Account
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.OnSuccessListener
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

/** One Tap API 활용을 위한 클래스 */
@ViewModelScoped
class GoogleOneTap @Inject constructor(
    private val oneTapClient: SignInClient,
    private val clientId: String,
    private val accountManager: AccountManager
) {
    fun signOut() {
        oneTapClient.signOut()
        accountManager.logout()
    }

    fun onActicityResult(result: ActivityResult, onSuccess: (Account) -> Unit = {}) {
        when (result.resultCode) {
            Activity.RESULT_OK -> {
                val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
                val token = credential.googleIdToken ?: ""
                val id = token ?: ""
                val email = credential.id
                val name = credential.givenName ?: ""

                val account = Account(id=id, token=token, email=email, name=name)
                Toast.makeText(MainApplication.context(), "{$name}님 안녕하세요!", Toast.LENGTH_SHORT).show()
                onSuccess(account)
            }
            Activity.RESULT_CANCELED -> {
                "One Tap Canceled!".log()
            }
        }
    }

    fun beginSignIn(
        launcher: IntentSenderLauncher,
    ) {
        val request = providesBeginSignIn()

        oneTapClient.beginSignIn(request)
            .addOnSuccessListener(onSuccessListener(launcher))
            .addOnFailureListener { e ->
                val context = MainApplication.context()
                val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)
                Toast.makeText(context, "Google Play: ${available}, ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                "No Google Accounts found. Just continue presenting the signed-out UI.".log()
                e.localizedMessage.log()
            }
    }

    /** 로그인 결과 반환할 정보를 설정한다. (ID Token 또는 Password Credential) */
    private fun providesBeginSignIn(): BeginSignInRequest {
        val idTokenOptions = providesIdTokenRequestOptions()

        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(idTokenOptions)
            .setAutoSelectEnabled(true)
            .build()
    }

    /** IdToken을 받고자 할 경우, 필요한 옵션 및 정보를 설정한다. */
    private fun providesIdTokenRequestOptions(): GoogleIdTokenRequestOptions {
        return GoogleIdTokenRequestOptions.builder()
            .setSupported(true)
            // Your server's client ID, not your Android client ID
            .setServerClientId(clientId)
            // Only show accounts previously used to sign in
            .setFilterByAuthorizedAccounts(false)
            .build()
    }

    /** Client 빌드가 성공적으로 완료된 이후 실행될 콜백 함수 */
    private fun onSuccessListener(
        launcher: IntentSenderLauncher
    ): OnSuccessListener<BeginSignInResult> {
        return object: OnSuccessListener<BeginSignInResult> {
            override fun onSuccess(p0: BeginSignInResult) {
                val senderRequest = IntentSenderRequest
                    .Builder(p0.pendingIntent)
                    .build()

                try {
                    launcher.launch(senderRequest)
                } catch (e: SendIntentException) {
                    val context = MainApplication.context()
                    val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)
                    Toast.makeText(context, "UI 호출 실패, ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
                    "Couldn't start One Tap UI: ${e.localizedMessage}".log()
                }
            }
        }
    }
}