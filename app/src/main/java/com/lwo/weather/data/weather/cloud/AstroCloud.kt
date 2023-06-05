package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.AstroData

data class AstroCloud(
    @SerializedName("moon_illumination") val moonIllumination: String?,
    @SerializedName("moon_phase") val moonPhase: String?,
    @SerializedName("moonrise") val moonrise: String?,
    @SerializedName("moonset") val moonset: String?,
    @SerializedName("sunrise") val sunrise: String?,
    @SerializedName("sunset") val sunset: String?,
    @SerializedName("is_moon_up") var isMoonUp: Int?,
    @SerializedName("is_sun_up") var isSunUp: Int?
)

fun AstroCloud.mapToData() = AstroData(
    moonIllumination = moonIllumination,
    moonPhase = moonPhase,
    moonrise = moonrise,
    moonset = moonset,
    sunrise = sunrise,
    sunset = sunset,
    isMoonUp = isMoonUp,
    isSunUp = isSunUp
)