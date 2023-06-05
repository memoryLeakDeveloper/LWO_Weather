package com.lwo.weather.data.weather.data

import com.google.gson.annotations.SerializedName

data class ConditionData(
    val code: Int?,
    val icon: String?,
    val text: String?
) {
    fun getConditionIcon() = "https://" + icon?.removePrefix("//")
}