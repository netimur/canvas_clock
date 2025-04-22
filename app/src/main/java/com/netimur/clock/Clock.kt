package com.netimur.clock

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.time.LocalTime
import kotlin.math.cos
import kotlin.math.sin

private const val MINUTES_ON_CLOCK_FACE = 60
private const val MILLISECONDS_IN_ONE_SECOND = 1000L

@Composable
fun Clock(
    modifier: Modifier = Modifier,
    style: ClockStyle,
    initialTime: LocalTime = LocalTime.now()
) {
    var time by remember {
        mutableStateOf(initialTime)
    }

    var secondAngle by remember(time) {
        mutableFloatStateOf((time.second * 6F - 90F).normalizeAngleOnAndroidCoordinateSystem())
    }

    var minutesAngle by remember(time) {
        mutableFloatStateOf((time.minute * 6F - 90F).normalizeAngleOnAndroidCoordinateSystem())
    }

    var hoursAngle by remember(time) {
        mutableFloatStateOf((time.hour % 12 * 30F - 90F).normalizeAngleOnAndroidCoordinateSystem())
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(MILLISECONDS_IN_ONE_SECOND)
            time = time.plusSeconds(1)
        }
    }

    Canvas(modifier = modifier) {
        val circleCenter = center
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                style.radius.toPx(),
                Paint().apply {
                    color = style.clockFaceColor
                    setShadowLayer(
                        20F,
                        0F,
                        0F,
                        Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        for (i in 0..MINUTES_ON_CLOCK_FACE) {
            val lineType = if (i % 5 == 0) {
                LineType.HOUR
            } else {
                LineType.MINUTE
            }
            val lineColor = when (lineType) {
                LineType.MINUTE -> style.minuteLineColor
                LineType.HOUR -> style.hourLineColor
            }

            val lineLength = when (lineType) {
                LineType.MINUTE -> style.minuteLineLength
                LineType.HOUR -> style.hourLineLength
            }

            val angleInRadians = (i * 6).toFloat().toRadians()

            val start = Offset(
                style.radius.toPx() * cos(angleInRadians) + circleCenter.x,
                style.radius.toPx() * sin(angleInRadians) + circleCenter.y
            )

            val end = Offset(
                (style.radius.toPx() - lineLength.toPx()) * cos(angleInRadians) + circleCenter.x,
                (style.radius.toPx() - lineLength.toPx()) * sin(angleInRadians) + circleCenter.y
            )

            drawLine(
                color = lineColor,
                start = start,
                end = end,
                strokeWidth = 2.dp.toPx()
            )
        }

        val secondAngleInRadians = secondAngle.toRadians()

        val secondStart = circleCenter
        val secondHandLength = with(style) {
            getMaxHandLength(
                radius = radius,
                hourLineLength = hourLineLength,
                minuteLineLength = minuteLineLength,
                handLength = secondHandLength,
            )
        }

        val secondEnd = Offset(
            x = secondHandLength.toPx() * cos(secondAngleInRadians) + circleCenter.x,
            y = secondHandLength.toPx() * sin(secondAngleInRadians) + circleCenter.y
        )

        drawLine(
            color = style.secondHandColor,
            start = secondStart,
            end = secondEnd,
            strokeWidth = style.secondHandWidth.toPx()
        )

        val minutesAngleInRadians = minutesAngle.toRadians()

        val minuteHandLength = with(style) {
            getMaxHandLength(
                radius = radius,
                hourLineLength = hourLineLength,
                minuteLineLength = minuteLineLength,
                handLength = minuteHandLength,
            )
        }

        val minutesStart = circleCenter
        val minutesEnd = Offset(
            x = minuteHandLength.toPx() * cos(minutesAngleInRadians) + circleCenter.x,
            y = minuteHandLength.toPx() * sin(minutesAngleInRadians) + circleCenter.y
        )

        drawLine(
            color = style.minuteHandColor,
            start = minutesStart,
            end = minutesEnd,
            strokeWidth = style.minuteHandWidth.toPx()
        )

        val hourHandLength = with(style) {
            getMaxHandLength(
                radius = radius,
                hourLineLength = hourLineLength,
                minuteLineLength = minuteLineLength,
                handLength = hourHandLength,
            )
        }

        val hoursAngleInRadians = hoursAngle.toRadians()
        val hoursStart = circleCenter
        val hoursEnd = Offset(
            x = hourHandLength.toPx() * cos(hoursAngleInRadians) + circleCenter.x,
            y = hourHandLength.toPx() * sin(hoursAngleInRadians) + circleCenter.y
        )

        drawLine(
            color = style.hourHandColor,
            start = hoursStart,
            end = hoursEnd,
            strokeWidth = style.hourHandWidth.toPx()
        )
    }
}