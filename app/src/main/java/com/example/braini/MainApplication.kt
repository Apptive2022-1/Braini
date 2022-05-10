package com.example.braini

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    init { instance = this }

    companion object {
        lateinit var instance: Application
        fun context() = instance as Context
    }
}