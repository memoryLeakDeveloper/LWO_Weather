package com.lwo.weather.core.cloud

sealed interface CloudResponse<T> {

    class Success<T>(val result: T) : CloudResponse<T>

    class Loading<T> : CloudResponse<T>

    class Error<Nothing>(val exception: Throwable?) : CloudResponse<Nothing>
}

fun <R> CloudResponse<R>.getResult(
    success: (CloudResponse.Success<R>) -> Unit,
    failure: (CloudResponse.Error<Nothing>) -> Unit,
    loading: ((CloudResponse.Loading<Nothing>) -> Unit)? = null
) = when (this) {
    is CloudResponse.Success -> success(this)
    is CloudResponse.Loading -> loading?.invoke(CloudResponse.Loading())
    else -> failure(CloudResponse.Error((this as CloudResponse.Error).exception))
}