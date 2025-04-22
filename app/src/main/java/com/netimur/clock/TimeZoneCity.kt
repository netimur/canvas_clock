package com.netimur.clock

enum class TimeZoneCity(val nativeName: String, val zoneId: String) {
    TOKYO("東京", "Asia/Tokyo"),
    PARIS("Paris", "Europe/Paris"),
    LONDON("London", "Europe/London"),
    ROME("Roma", "Europe/Rome"),
    NEW_YORK("New York", "America/New_York"),
    ASTANA("Алматы", "Asia/Almaty"),
    SHANGHAI("上海", "Asia/Shanghai"),
    MOSCOW("Москва", "Europe/Moscow"),
    SYDNEY("Sydney", "Australia/Sydney"),
    BARCELONA("Barcelona", "Europe/Madrid")
}