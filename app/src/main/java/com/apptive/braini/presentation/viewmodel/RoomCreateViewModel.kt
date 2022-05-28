package com.apptive.braini.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.braini._enums.Side

class RoomCreateViewModel : ViewModel() {
    var roomTitle: MutableState<String> = mutableStateOf("프로젝트명을 입력하세요")
    var roomNumber: MutableState<Int> = mutableStateOf(0)
    var callable: MutableState<Side> = mutableStateOf(Side.LEFT)
    var isPublic: MutableState<Side> = mutableStateOf(Side.RIGHT)
    // 프로퍼티
    val isFilled: Boolean get()  {
        if (!roomTitle.value.isEmpty()) return false
        if (roomNumber.value > 0) return false

        return true
    }
}