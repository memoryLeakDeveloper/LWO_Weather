package com.lwo.weather.data.registration

import com.lwo.weather.core.cloud.ApiLocal
import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.utils.bugger

class RegistrationRepository {

    suspend fun registerUser(login: String, email: String, password: String): CloudResponse<RegistrationResponseData> {
        runCatching {
            val response = ApiLocal().makeService(RegistrationService::class.java).register(RegistrationData(login, email, password))
            response.body()?.let {
                return CloudResponse.Success(it)
            } ?: run {
                return CloudResponse.Error(Exception())
            }
        }.getOrElse {
            return CloudResponse.Error(it)
        }
    }
}