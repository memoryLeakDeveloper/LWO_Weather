package com.lwo.weather.data.search

import com.lwo.weather.core.cloud.Api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchCitiesService {
    @GET("${Api.apiV1}/search.json")
    suspend fun searchCities(@Query("key") auth: String, @Query("q") query: String): Response<List<SearchCloud>>
}