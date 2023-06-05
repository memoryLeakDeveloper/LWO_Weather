package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.ConditionData

data class ConditionCloud(
    @SerializedName("code") val code: Int?,
    @SerializedName("icon") val icon: String?,
    @SerializedName("text") val text: String?
)

fun ConditionCloud.mapToData() = ConditionData(
    code = code,
    icon = icon,
    text = text
)