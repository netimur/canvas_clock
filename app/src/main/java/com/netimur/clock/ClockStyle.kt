package com.netimur.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

data class ClockStyle(
    val clockFaceColor: Int = android.graphics.Color.WHITE,
    val minuteLineColor: Color = Color.LightGray,
    val hourLineColor: Color = Color.Black,
    val secondHandColor: Color = Color.Red,
    val minuteHandColor: Color = Color.Black,
    val hourHandColor: Color = Color.Black,
    private val _radius: Dp = 100.dp,
    private val _minuteLineLength: Dp = 10.dp,
    private val _hourLineLength: Dp = 20.dp,
    private val _secondHandLength: Dp = 70.dp,
    private val _minuteHandLength: Dp = 60.dp,
    private val _hourHandLength: Dp = 45.dp,
    private val _secondHandWidth: Dp = 1.dp,
    private val _minuteHandWidth: Dp = 2.dp,
    private val _hourHandWidth: Dp = 3.dp
) {
    val radius: Dp
        get() = _radius.value.absoluteValue.dp

    val minuteLineLength: Dp
        get() = _minuteLineLength.value.absoluteValue.dp

    val hourLineLength: Dp
        get() = _hourLineLength.value.absoluteValue.dp

    val secondHandLength: Dp
        get() = _secondHandLength.value.absoluteValue.dp

    val minuteHandLength: Dp
        get() = _minuteHandLength.value.absoluteValue.dp

    val hourHandLength: Dp
        get() = _hourHandLength.value.absoluteValue.dp

    val secondHandWidth: Dp
        get() = _secondHandWidth.value.absoluteValue.dp

    val minuteHandWidth: Dp
        get() = _minuteHandWidth.value.absoluteValue.dp

    val hourHandWidth: Dp
        get() = _hourHandWidth.value.absoluteValue.dp
}