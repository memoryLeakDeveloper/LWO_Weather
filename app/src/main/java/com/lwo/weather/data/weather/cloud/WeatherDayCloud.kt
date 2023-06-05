package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.WeatherDayData

data class WeatherDayCloud(
    val avghumidity: Int?,
    @SerializedName("avgtemp_c") val avgtempC: Double?,
    @SerializedName("avgtemp_f") val avgtempF: Double?,
    @SerializedName("avgvis_km") val avgvisKm: Double?,
    @SerializedName("avgvis_miles") val avgvisMiles: Int?,
    @SerializedName("condition") val condition: ConditionCloud?,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int?,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int?,
    @SerializedName("daily_will_it_rain") val dailyWillItRain: Int?,
    @SerializedName("daily_will_it_snow") val dailyWillItSnow: Int?,
    @SerializedName("maxtemp_c") val maxtempC: Double?,
    @SerializedName("maxtemp_f") val maxtempF: Double?,
    @SerializedName("maxwind_kph") val maxwindKph: Double?,
    @SerializedName("maxwind_mph") val maxwindMph: Double?,
    @SerializedName("mintemp_c") val mintempC: Double?,
    @SerializedName("mintemp_f") val mintempF: Double?,
    @SerializedName("totalprecip_in") val totalprecipIn: Double?,
    @SerializedName("totalprecip_mm") val totalprecipMm: Double?,
    @SerializedName("totalsnow_cm") val totalsnowCm: Int?,
    @SerializedName("uv") val uv: Int?
)

fun WeatherDayCloud.mapToData() = WeatherDayData(
    avghumidity = avghumidity,
    avgtempC = avgtempC,
    avgtempF = avgtempF,
    avgvisKm = avgvisKm,
    avgvisMiles = avgvisMiles,
    condition = condition?.mapToData(),
    dailyChanceOfRain = dailyChanceOfRain,
    dailyChanceOfSnow = dailyChanceOfSnow,
    dailyWillItRain = dailyWillItRain,
    dailyWillItSnow = dailyWillItSnow,
    maxtempC = maxtempC,
    maxtempF = maxtempF,
    maxwindKph = maxwindKph,
    maxwindMph = maxwindMph,
    mintempC = mintempC,
    mintempF = mintempF,
    totalprecipIn = totalprecipIn,
    totalprecipMm = totalprecipMm,
    totalsnowCm = totalsnowCm,
    uv = uv
)