package com.apptive.braini.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel

class RoomCreateViewModel : ViewModel(),
    IRoomCreateViewModel {
    override var roomTitle: MutableState<String> = mutableStateOf("프로젝트명을 입력하세요")
    override var roomNumber: MutableState<Int> = mutableStateOf(0)
    override var callable: MutableState<Side> = mutableStateOf(Side.LEFT)
    override var isPublic: MutableState<Side> = mutableStateOf(Side.RIGHT)
    // 프로퍼티
    override val isFilled: Boolean get()  {
        if (!roomTitle.value.isEmpty()) return false
        if (roomNumber.value > 0) return false

        return true
    }
}