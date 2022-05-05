package com.example.braini.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.braini.domain.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore("settings")

class UserPref @Inject constructor(@ApplicationContext context: Context){
    private val userStore = context.dataStore

    suspend fun setLoggedInUser(user: User) {
        userStore.edit { storeMap ->
            storeMap[LOGGED_IN_USER_ID] = user.id
            storeMap[LOGGED_IN_USER_EMAIL] = user.email
            storeMap[LOGGED_IN_USER_NAME] = user.name
            storeMap[LOGGED_IN_USER_TOKEN] = user.token
        }
    }

    fun getLoggedInUser() : Flow<User> {
        return userStore.data.map { storeMap ->
            val id = storeMap[LOGGED_IN_USER_ID] ?: User.GUEST.id
            val email = storeMap[LOGGED_IN_USER_EMAIL] ?: User.GUEST.email
            val name = storeMap[LOGGED_IN_USER_NAME] ?: User.GUEST.name
            val token =  storeMap[LOGGED_IN_USER_TOKEN] ?: User.GUEST.token

            User(id = id, email = email, name = name)
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