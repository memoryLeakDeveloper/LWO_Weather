package com.lwo.weather.data.login

import com.lwo.weather.core.cloud.ApiLocal
import com.lwo.weather.core.cloud.CloudResponse

class LoginRepository {

    suspend fun loginUser(login: String, password: String): CloudResponse<LoginResponseData> {
        runCatching {
            val response = ApiLocal().makeService(LoginService::class.java).register(LoginData(login, password))
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