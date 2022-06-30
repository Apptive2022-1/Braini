package com.apptive.braini.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.braini._enums.Side
import com.apptive.braini.presentation.viewmodel.interfaces.IRoomCreateViewModel
import com.chargemap.compose.numberpicker.AMPMHours

//실제 앱이 돌아갈때 쓰이는
class RoomCreateViewModel : ViewModel(),
    IRoomCreateViewModel {
    override var roomTitle: MutableState<String> = mutableStateOf(PROJECT_DEFAULT)
    override var roomNumber: MutableState<Int> = mutableStateOf(0)
    override var roomDate: MutableState<Int> = mutableStateOf(20220622)
    override var callable: MutableState<Side> = mutableStateOf(Side.LEFT)
    override var isPublic: MutableState<Side> = mutableStateOf(Side.RIGHT)
    override var year: MutableState<Int> = mutableStateOf(0)
    override var month: MutableState<Int> = mutableStateOf(0)
    override var day: MutableState<Int> = mutableStateOf(0)
    override var hour: MutableState<Int> = mutableStateOf(0)
    override var minute: MutableState<Int> = mutableStateOf(0)
    override var AMPM: MutableState<AMPMHours.DayTime> = mutableStateOf(AMPMHours.DayTime.AM)
    // 프로퍼티
    override val isFilled: Boolean get()  {
        if (roomTitle.value.isEmpty()) return false
        if (roomNumber.value < 1) return false
        if (roomDate.value <0) return false

        return true
    }

    companion object {
        val PROJECT_DEFAULT = "프로젝트 명을 입력하세요"
    }
}