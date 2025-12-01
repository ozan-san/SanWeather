package com.ozansan.sanweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozansan.sanweather.location.LocationRepository
import com.ozansan.sanweather.network.WeatherApiService
import com.ozansan.sanweather.util.WeatherCodeMapper
import com.ozansan.sanweather.util.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface WeatherUiState {
    data object Loading : WeatherUiState
    data class Success(
        val weatherInfo: WeatherInfo,
        val temperature: Double,
        val cityName: String? = null
    ) : WeatherUiState
    data class Error(val message: String) : WeatherUiState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherApiService: WeatherApiService,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val weatherState: StateFlow<WeatherUiState> = _weatherState

    init {
        fetchWeatherForCurrentLocation()
    }

    fun fetchWeatherForCurrentLocation() {
        viewModelScope.launch {
            _weatherState.value = WeatherUiState.Loading
            try {
                val currentLocation = locationRepository.getCurrentLocation().first()
                val lat = currentLocation.latitude
                val long = currentLocation.longitude
                val cityName = locationRepository.getCityName(lat, long)

                val response = weatherApiService.getWeather(
                    latitude = lat,
                    longitude = long,
                    hourly = "temperature_2m,weather_code",
                    current = "weather_code,is_day,temperature_2m",
                    timezone = "Europe/Istanbul"
                )

                val weatherInfo = WeatherCodeMapper.getWeatherInfo(
                    code = response.current.weatherCode,
                    isDay = response.current.isDay
                )

                _weatherState.value = WeatherUiState.Success(
                    weatherInfo = weatherInfo,
                    temperature = response.current.temperature2m,
                    cityName = cityName
                )

            } catch (e: Exception) {
                _weatherState.value = WeatherUiState.Error("API Error: ${e.message}")
            }
        }
    }
}