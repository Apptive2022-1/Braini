package com.example.braini.data.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.braini.domain.model.Account
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore("account")

class AccountStore @Inject constructor(@ApplicationContext context: Context){
    private val store = context.dataStore

    suspend fun setLoggedInUser(account: Account) {
        store.edit { storeMap ->
            storeMap[LOGGED_IN_USER_ID] = account.id
            storeMap[LOGGED_IN_USER_EMAIL] = account.email
            storeMap[LOGGED_IN_USER_NAME] = account.name
            storeMap[LOGGED_IN_USER_TOKEN] = account.token
        }
    }

    fun getLoggedInUser() : Flow<Account>  {
        return store.data.map { storeMap ->
            val id = storeMap[LOGGED_IN_USER_ID] ?: Account.GUEST.id
            val email = storeMap[LOGGED_IN_USER_EMAIL] ?: Account.GUEST.email
            val name = storeMap[LOGGED_IN_USER_NAME] ?: Account.GUEST.name
            val token =  storeMap[LOGGED_IN_USER_TOKEN] ?: Account.GUEST.token

            Account(id = id, email = email, name = name, token = token)
        }
    }

    // 키값 정의
    companion object {
        private val LOGGED_IN_USER_ID = stringPreferencesKey("logged_in_user_id")
        private val LOGGED_IN_USER_EMAIL = stringPreferencesKey("logged_in_user_email")
        private val LOGGED_IN_USER_NAME = stringPreferencesKey("logged_in_user_name")
        private val LOGGED_IN_USER_TOKEN = stringPreferencesKey("logged_in_user_token")
    }
}