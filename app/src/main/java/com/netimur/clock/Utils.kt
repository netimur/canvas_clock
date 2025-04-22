package com.netimur.clock

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

const val ANGLES_IN_CIRCLE = 360F

fun Float.toRadians(): Float {
    return this * Math.PI.toFloat() / 180F
}

fun getMaxHandLength(
    radius: Dp,
    hourLineLength: Dp,
    minuteLineLength: Dp,
    handLength: Dp
): Dp {
    val maximumLineLength = max(minuteLineLength, hourLineLength)
    val maxSecondHandLength = radius - maximumLineLength
    return handLength.coerceIn(
        minimumValue = 0.dp,
        maximumValue = maxSecondHandLength
    )
}

fun Float.normalizeAngleOnAndroidCoordinateSystem(): Float {
    return (mod(ANGLES_IN_CIRCLE) + ANGLES_IN_CIRCLE) % ANGLES_IN_CIRCLE
}

fun getTimeForCity(city: TimeZoneCity): LocalTime {
    return try {
        ZonedDateTime.now(ZoneId.of(city.zoneId)).toLocalTime()
    } catch (_: Exception) {
        LocalTime.now()
    }
}