package com.lwo.weather.data.registration

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationService {
    @POST("/register")
    suspend fun register(@Body data: RegistrationData): Response<RegistrationResponseData>
}