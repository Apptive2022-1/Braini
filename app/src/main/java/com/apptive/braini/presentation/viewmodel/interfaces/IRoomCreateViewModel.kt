package com.apptive.braini.presentation.viewmodel.interfaces

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini._enums.Side

interface IRoomCreateViewModel {
    var roomTitle: MutableState<String>
    var roomNumber: MutableState<Int>
    var callable: MutableState<Side>
    var isPublic: MutableState<Side>
    // 프로퍼티
    val isFilled: Boolean
}