package com.ozansan.sanweather.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    @Json(name = "generationtime_ms")
    val generationtimeMs: Double,
    @Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int,
    val timezone: String,
    @Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: Double,
    @Json(name = "current_units")
    val currentUnits: CurrentUnits,
    val current: Current,
    @Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    val hourly: Hourly
)

@JsonClass(generateAdapter = true)
data class CurrentUnits(
    val time: String,
    val interval: String,
    @Json(name = "weather_code")
    val weatherCode: String,
    @Json(name = "temperature_2m")
    val temperature2m: String
)

@JsonClass(generateAdapter = true)
data class Current(
    val time: String,
    val interval: Int,
    @Json(name = "weather_code")
    val weatherCode: Int,
    @Json(name = "is_day")
    val isDay: Int,
    @Json(name = "temperature_2m")
    val temperature2m: Double
)

@JsonClass(generateAdapter = true)
data class HourlyUnits(
    val time: String,
    @Json(name = "temperature_2m")
    val temperature2m: String,
    @Json(name = "weather_code")
    val weatherCode: String
)

@JsonClass(generateAdapter = true)
data class Hourly(
    val time: List<String>,
    @Json(name = "temperature_2m")
    val temperature2m: List<Double>,
    @Json(name = "weather_code")
    val weatherCode: List<Int>
)
