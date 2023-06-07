package com.lwo.weather.ui.fragment.state

import com.airbnb.mvrx.MavericksState
import com.lwo.weather.data.search.SearchData
import com.lwo.weather.ui.fragment.data.WeatherDataUi

data class ScreenState(
    val data: WeatherDataUi? = null,
    val error: Throwable? = null,
    val loading: Boolean? = null,
    val search: List<SearchData>? = null
) : MavericksState

fun ScreenState.getState(): State {
    return if (data != null) State.Success
    else if (error != null) State.Error
    else if (search != null) State.Search
    else State.Loading
}