package com.lwo.weather.data.search

import com.lwo.weather.core.cloud.Api
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchCitiesService {
    @GET("${Api.apiV1}/search.json")
    fun searchCities(@Query("key") auth: String, @Query("q") query: String): Call<List<SearchCloud>>
}