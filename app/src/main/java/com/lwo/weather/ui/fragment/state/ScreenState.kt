package com.lwo.weather.ui.fragment.state

import com.airbnb.mvrx.MavericksState
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData

data class ScreenState(
    val data: CurrentWeatherComposeData? = null,
    val error: Throwable? = null,
    val loading: Boolean? = null
) : MavericksState

fun ScreenState.getState(): State {
    return if (data != null) State.Success
    else if (error != null) State.Error
    else State.Loading
}