package com.lwo.weather.data.weather.data

data class AstroData(
    val moonIllumination: String?,
    val moonPhase: String?,
    val moonrise: String?,
    val moonset: String?,
    val sunrise: String?,
    val sunset: String?,
    var isMoonUp: Int?,
    var isSunUp: Int?
)