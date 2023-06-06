package com.lwo.weather.data.search

import com.google.gson.annotations.SerializedName

data class SearchCloud(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("region") val region: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lon") val lon: Double?,
    @SerializedName("url") val url: String?,
)

fun SearchCloud.mapToData() = SearchData(id, name, region, country, lat, lon, url)