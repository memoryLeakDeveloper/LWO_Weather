package com.lwo.weather.core.cloud

import com.lwo.weather.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ExceptionHandler {

    fun recognizeReason(error: Throwable?) = when (error) {
        is ConnectException, is UnknownHostException -> {
            R.string.error_loading_data
        }

        is SocketTimeoutException -> {
            R.string.server_error
        }

        else -> {
            R.string.something_is_wrong
        }
    }
}