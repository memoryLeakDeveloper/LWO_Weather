package com.lwo.weather.core.cloud

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiLocal {

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
        const val BASE_URL = "http://192.168.31.68:8080"
    }

}