package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.WeatherData

data class WeatherCloud(
    @SerializedName("last_updated") val lastUpdated: String?,
    @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Int?,
    @SerializedName("temp_c") val tempC: Float?,
    @SerializedName("temp_f") val tempF: Float?,
    @SerializedName("feelslike_c") val feelslikeC: Float?,
    @SerializedName("feelslike_f") val feelslikeF: Float?,
    @SerializedName("condition") val condition: ConditionCloud?,
    @SerializedName("wind_mph") val windMph: Float?,
    @SerializedName("wind_kph") val windKph: Float?,
    @SerializedName("wind_degree") val windDegree: Int?,
    @SerializedName("wind_dir") val windDir: String?,
    @SerializedName("pressure_mb") val pressureMb: Float?,
    @SerializedName("pressure_in") val pressureIn: Float?,
    @SerializedName("precip_mm") val precipMm: Float?,
    @SerializedName("precip_in") val precipIn: Float?,
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("cloud") val cloud: Int?,
    @SerializedName("is_day") val isDay: Int?,
    @SerializedName("uv") val uv: Float?,
    @SerializedName("gust_mph") val gustMph: Float?,
    @SerializedName("gust_kph") val gustKph: Float?
)

fun WeatherCloud.mapToData() = WeatherData(
    lastUpdated,
    lastUpdatedEpoch,
    tempC,
    tempF,
    feelslikeC,
    feelslikeF,
    condition?.mapToData(),
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
