package com.netimur.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

val darkElegance = ClockStyle(
    clockFaceColor = Color(0xFF121212).toArgb(),
    minuteLineColor = Color(0xFF2C2C2C),
    hourLineColor = Color(0xFF444444),
    secondHandColor = Color(0xFFFF5252),
    minuteHandColor = Color(0xFFFFFFFF),
    hourHandColor = Color(0xFFE0E0E0)
)

val sandAndEspresso = ClockStyle(
    clockFaceColor = Color(0xFFF5DEB3).toArgb(),
    minuteLineColor = Color(0xFFCDB38B),
    hourLineColor = Color(0xFF8B5A2B),
    secondHandColor = Color(0xFFB22222),
    minuteHandColor = Color(0xFF4B3621),
    hourHandColor = Color(0xFF3B2F2F)
)

val softPastel = ClockStyle(
    clockFaceColor = Color(0xFFFFF1F8).toArgb(),
    minuteLineColor = Color(0xFFE1BEE7),
    hourLineColor = Color(0xFFCE93D8),
    secondHandColor = Color(0xFFD81B60),
    minuteHandColor = Color(0xFF6A1B9A),
    hourHandColor = Color(0xFF4A148C)
)

val cyberpunk = ClockStyle(
    clockFaceColor = Color(0xFF000000).toArgb(),
    minuteLineColor = Color(0xFF00FFFF),
    hourLineColor = Color(0xFF8A2BE2),
    secondHandColor = Color(0xFFFF00FF),
    minuteHandColor = Color(0xFF00FFFF),
    hourHandColor = Color(0xFFFF1493)
)

val oceanBreeze =  ClockStyle(
    clockFaceColor = Color(0xFFE0F7FA).toArgb(),
    minuteLineColor = Color(0xFF4DD0E1),
    hourLineColor = Color(0xFF00838F),
    secondHandColor = Color(0xFF006064),
    minuteHandColor = Color(0xFF00ACC1),
    hourHandColor = Color(0xFF00838F)
)

val earthyTones =  ClockStyle(
    clockFaceColor = Color(0xFFFDF6E3).toArgb(),
    minuteLineColor = Color(0xFF93A1A1),
    hourLineColor = Color(0xFF586E75),
    secondHandColor = Color(0xFFDC322F),
    minuteHandColor = Color(0xFF657B83),
    hourHandColor = Color(0xFF073642)
)

val snowAndIce = ClockStyle(
    clockFaceColor = Color(0xFFF0F8FF).toArgb(),
    minuteLineColor = Color(0xFFB0C4DE),
    hourLineColor = Color(0xFF4682B4),
    secondHandColor = Color(0xFF4169E1),
    minuteHandColor = Color(0xFF1E90FF),
    hourHandColor = Color(0xFF000080)
)

val retroDigital =  ClockStyle(
    clockFaceColor = Color(0xFF2C3E50).toArgb(),
    minuteLineColor = Color(0xFF16A085),
    hourLineColor = Color(0xFF1ABC9C),
    secondHandColor = Color(0xFFE74C3C),
    minuteHandColor = Color(0xFFECF0F1),
    hourHandColor = Color(0xFFBDC3C7)
)

val sunsetTheme = ClockStyle(
    clockFaceColor = Color(0xFFFFF3E0).toArgb(),
    minuteLineColor = Color(0xFFFFB74D),
    hourLineColor = Color(0xFFF57C00),
    secondHandColor = Color(0xFFFF5722),
    minuteHandColor = Color(0xFFEF6C00),
    hourHandColor = Color(0xFFE65100)
)

val paperInk = ClockStyle(
    clockFaceColor = Color(0xFFFFFBF0).toArgb(),
    minuteLineColor = Color(0xFF999999),
    hourLineColor = Color(0xFF444444),
    secondHandColor = Color(0xFFCC0000),
    minuteHandColor = Color(0xFF222222),
    hourHandColor = Color(0xFF111111)
)

val clocks = listOf(
    paperInk,
    sunsetTheme,
    retroDigital,
    snowAndIce,
    earthyTones,
    oceanBreeze,
    cyberpunk,
    darkElegance,
    sandAndEspresso,
    softPastel
)