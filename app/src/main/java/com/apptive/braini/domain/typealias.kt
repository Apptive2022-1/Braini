package com.apptive.braini.domain

import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest

/** Activity Result API: Intent Sender Request */
typealias IntentSenderLauncher = ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>