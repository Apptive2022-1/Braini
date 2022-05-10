package com.example.braini.domain

import android.util.Log

fun String.log(header: String = "브레이니") {
    Log.d(header, this)
}