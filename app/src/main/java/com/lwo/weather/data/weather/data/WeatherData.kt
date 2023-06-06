package com.lwo.weather.data.weather.data

data class WeatherData(
    val lastUpdated: String?,
    val lastUpdatedEpoch: Int?,
    val tempC: Float?,
    val tempF: Float?,
    val feelslikeC: Float?,
    val feelslikeF: Float?,
    val conditionData: ConditionData?,
    val windMph: Float?,
    val windKph: Float?,
    val windDegree: Int?,
    val windDir: String?,
    val pressureMb: Float?,
    val pressureIn: Float?,
    val precipMm: Float?,
    val precipIn: Float?,
    val humidity: Int?,
    val cloud: Int?,
    val isDay: Int?,
    val uv: Float?,
    val gustMph: Float?,
    val gustKph: Float?
)
