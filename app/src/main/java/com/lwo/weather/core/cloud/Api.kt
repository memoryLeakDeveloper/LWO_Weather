package com.lwo.weather.core.cloud

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {

    private var retrofit = Retrofit.Builder()

    fun <T> makeService(clazz: Class<T>): T = retrofit.baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(makeOkHttpClient())
        .build()
        .create(clazz)

    private fun makeOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
        return builder.build()
    }

    companion object {
        private const val BASE_URL = "http://api.weatherapi.com"
        const val API_KEY = "abd42e9b9fb1471c959102954230506"
        const val apiV1 = "/v1"
    }
}