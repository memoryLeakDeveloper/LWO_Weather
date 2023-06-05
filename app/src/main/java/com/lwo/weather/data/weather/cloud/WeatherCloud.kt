package com.lwo.weather.data.weather.cloud

import com.lwo.weather.data.weather.data.WeatherData

data class WeatherCloud(
    val lastUpdated: String?,
    val lastUpdatedEpoch: Int?,
    val tempC: Float?,
    val tempF: Float?,
    val feelslikeC: Float?,
    val feelslikeF: Float?,
    val conditionText: String?,
    val conditionIcon: String?,
    val conditionCode: Int?,
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

fun WeatherCloud.mapToData() = WeatherData(
    lastUpdated,
    lastUpdatedEpoch,
    tempC,
    tempF,
    feelslikeC,
    feelslikeF,
    conditionText,
    conditionIcon,
    conditionCode,
    windMph,
    windKph,
    windDegree,
    windDir,
    pressureMb,
    pressureIn,
    precipMm,
    precipIn,
    humidity,
    cloud,
    isDay,
    uv,
    gustMph,
    gustKph
)
