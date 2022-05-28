package com.apptive.braini.presentation.viewmodel.mock

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel

class RoomCreateViewModelMock: IRoomCreateViewModel {
    override var roomTitle: MutableState<String> = mutableStateOf("")
    override var roomNumber: MutableState<Int> = mutableStateOf(0)
    override var callable: MutableState<Side> = mutableStateOf(Side.LEFT)
    override var isPublic: MutableState<Side> = mutableStateOf(Side.LEFT)
    override val isFilled: Boolean get() = true
}