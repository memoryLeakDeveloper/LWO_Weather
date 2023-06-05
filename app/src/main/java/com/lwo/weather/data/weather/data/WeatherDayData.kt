package com.lwo.weather.data.weather.data

data class WeatherDayData(
    val avghumidity: Int?,
    val avgtempC: Double?,
    val avgtempF: Double?,
    val avgvisKm: Double?,
    val avgvisMiles: Int?,
    val condition: ConditionData?,
    val dailyChanceOfRain: Int?,
    val dailyChanceOfSnow: Int?,
    val dailyWillItRain: Int?,
    val dailyWillItSnow: Int?,
    val maxtempC: Double?,
    val maxtempF: Double?,
    val maxwindKph: Double?,
    val maxwindMph: Double?,
    val mintempC: Double?,
    val mintempF: Double?,
    val totalprecipIn: Double?,
    val totalprecipMm: Double?,
    val totalsnowCm: Int?,
    val uv: Int?
)