package com.ozansan.sanweather.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String,
        @Query("current") current: String,
        @Query("timezone") timezone: String
    ): WeatherResponse
}