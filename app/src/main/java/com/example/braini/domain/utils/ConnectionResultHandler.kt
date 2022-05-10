package com.example.braini.domain.utils

import android.content.Context
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult.*
import com.google.android.gms.common.GoogleApiAvailability

object ConnectionResultHandler {
    fun handleErrorCode(context: Context) {
        val apiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = apiAvailability.isGooglePlayServicesAvailable(context)
        val errorMessage = when(resultCode) {
            CANCELED -> "인터넷 연결이 site."
            SERVICE_INVALID -> "구글 플레이 버전이 유효하지 않습니다."
            else -> "유효하지 않은 에러 코드"
        }

        Toast.makeText(context, "(코드: $resultCode) $errorMessage", Toast.LENGTH_LONG).show()
    }
}