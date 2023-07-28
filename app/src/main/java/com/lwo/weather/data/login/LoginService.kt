package com.lwo.weather.data.login

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/login")
    suspend fun register(@Body data: LoginData): Response<LoginResponseData>
}