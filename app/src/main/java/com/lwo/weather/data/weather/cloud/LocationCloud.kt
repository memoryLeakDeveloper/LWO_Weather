package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.LocationData

data class LocationCloud(
    @SerializedName("country") val country: String?,
    @SerializedName("lat") val lat: Double?,
    @SerializedName("localtime") val localtime: String?,
    @SerializedName("localtime_epoch") val localtimeEpoch: Int?,
    @SerializedName("lon") val lon: Double?,
    @SerializedName("name") val name: String?,
    @SerializedName("region") val region: String?,
    @SerializedName("tz_id") val tzId: String?
)

fun LocationCloud.mapToData() = LocationData(country, lat, localtime, localtimeEpoch, lon, name, region, tzId)