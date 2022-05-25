package com.apptive.braini.domain.utils

import com.apptive.braini.data.storage.AccountStore
import com.apptive.braini.domain.log
import com.apptive.braini.domain.model.Account
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

/** 현재 앱에 로그인된 유저를 관리한다. */
@Singleton
class AccountManager @Inject constructor(
    private val accountStore: AccountStore
) {
    var currentAccount = Account.GUEST

    init { observeLoggedInAccount() }

    fun login(account: Account) {
        CoroutineScope(Dispatchers.IO).launch {
            accountStore.setLoggedInUser(account)
        }
    }

    fun logout() {
        CoroutineScope(Dispatchers.IO).launch {
            accountStore.setLoggedInUser(Account.GUEST)
        }
    }

    fun isLoggedIn() = (currentAccount != Account.GUEST)

    private fun observeLoggedInAccount() {
        CoroutineScope(Dispatchers.IO).launch {
            accountStore.getLoggedInUser().collect {
                currentAccount = it
                "로그인 감지: $currentAccount".log()
            }
        }
    }
}