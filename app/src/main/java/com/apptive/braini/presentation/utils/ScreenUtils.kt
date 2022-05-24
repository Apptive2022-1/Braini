package com.apptive.braini.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ScreenUtils {
    @Composable
    fun height(percent: Int? = null): Dp {
        val maxHeight = LocalConfiguration.current.screenHeightDp
        if (percent == null) return maxHeight.dp

        return (maxHeight * percent/100).dp
    }

    @Composable
    fun width(percent: Int? = null): Dp {
        val maxHeight = LocalConfiguration.current.screenWidthDp
        if (percent == null) return maxHeight.dp

        return (maxHeight * percent/100).dp
    }
}