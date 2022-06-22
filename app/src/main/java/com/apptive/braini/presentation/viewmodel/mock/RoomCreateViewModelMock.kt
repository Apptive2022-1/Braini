package com.apptive.braini.presentation.viewmodel.mock

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel
import com.chargemap.compose.numberpicker.AMPMHours

//preview 오류 때문에
//tdd
class RoomCreateViewModelMock: IRoomCreateViewModel {
    override var roomTitle: MutableState<String> = mutableStateOf("")
    override var roomNumber: MutableState<Int> = mutableStateOf(1)
    override var roomDate: MutableState<Int> = mutableStateOf(20220622)
    override var callable: MutableState<Side> = mutableStateOf(Side.LEFT)
    override var isPublic: MutableState<Side> = mutableStateOf(Side.LEFT)
    override var hour: MutableState<Int> = mutableStateOf(0)
    override var minute: MutableState<Int> = mutableStateOf(0)
    override var AMPM: MutableState<AMPMHours.DayTime> = mutableStateOf(AMPMHours.DayTime.AM)
    override var year: MutableState<Int> = mutableStateOf(2022)
    override var month: MutableState<Int> = mutableStateOf(8)
    override var day: MutableState<Int> = mutableStateOf(25)

    override val isFilled: Boolean get() = true
}