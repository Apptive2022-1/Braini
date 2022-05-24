package com.apptive.braini.domain.di

import android.content.Context
import com.apptive.braini.R
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class OneTapModule {

    @ViewModelScoped
    @Provides
    fun providesOneTapClient(@ApplicationContext context: Context): SignInClient {
        return Identity.getSignInClient(context)
    }

    @ViewModelScoped
    @Provides
    fun providesClientId(@ApplicationContext context: Context): String {
        return context.getString(R.string.client_id_server)
    }
}