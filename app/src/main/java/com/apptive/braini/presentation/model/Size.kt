package com.apptive.braini.presentation.model

import androidx.compose.ui.unit.Dp

/** UI 요소의 가로, 세로 길이를 담는 클래스 */
data class Size(
    val width: Dp,
    val height: Dp
) {
    constructor(size: Dp) : this(size, size)
}
