package com.apptive.braini.presentation.view

import com.chargemap.compose.numberpicker.NumberPicker

import androidx.compose.foundation.layout.Row
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import java.time.Month
import java.time.MonthDay
import java.time.Year
import java.time.YearMonth
import kotlin.math.abs

//sealed interface date {
//    val year: Int
//    val month: Int
//    val day: Int
//}

data class Fulldate(
    val year: Int,
    val month: Int,
    val day: Int,
)


@Composable
fun datePicker(
    modifier: Modifier = Modifier,
    value: Fulldate,
    leadingZero: Boolean = true,
    yearRange: Iterable<Int> = (2022..2025),
    monthRange: Iterable<Int> = (1..12),
    dayRange: Iterable<Int> = (1..31),
    yearDivider: (@Composable () -> Unit)? = null,
    monthDivider: (@Composable () -> Unit)? = null,
    dayDivider: (@Composable () -> Unit)? = null,
    onValueChange: (Fulldate) -> Unit,
    dividersColor: Color = MaterialTheme.colors.primary,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NumberPicker(
            modifier = Modifier.weight(1f),
            label = {
                "${if (leadingZero && abs(it) < 10) "0" else ""}$it"
            },
            value = value.year,
            onValueChange = {
                onValueChange(value.copy(year = it))
            },
            dividersColor = dividersColor,
            textStyle = textStyle,
            range = yearRange
        )

        yearDivider?.invoke()

        NumberPicker(
            modifier = Modifier.weight(1f),
            label = {
                "${if (leadingZero && abs(it) < 10) "0" else ""}$it"
            },
            value = value.month,
            onValueChange = {
                onValueChange(value.copy(month = it))
            },
            dividersColor = dividersColor,
            textStyle = textStyle,
            range = monthRange
        )

        monthDivider?.invoke()

        NumberPicker(
            modifier = Modifier.weight(1f),
            label = {
                "${if (leadingZero && abs(it) < 10) "0" else ""}$it"
            },
            value = value.day,
            onValueChange = {
                onValueChange(value.copy(day = it))
            },
            dividersColor = dividersColor,
            textStyle = textStyle,
            range = dayRange
        )

        dayDivider?.invoke()
    }
}
