package com.apptive.braini.presentation.viewmodel.interfaces

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.apptive.braini._enums.Side
import com.chargemap.compose.numberpicker.AMPMHours

//아래 항목들의 존재를 보장
interface IRoomCreateViewModel {
    var roomTitle: MutableState<String>
    var roomNumber: MutableState<Int>
    var roomDate: MutableState<Int>
    var callable: MutableState<Side>
    var isPublic: MutableState<Side>
    var hour: MutableState<Int>
    var minute: MutableState<Int>
    var AMPM: MutableState<AMPMHours.DayTime>
    var year: MutableState<Int>
    var month: MutableState<Int>
    var day: MutableState<Int>
    // 프로퍼티
    val isFilled: Boolean
}