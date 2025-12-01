package com.ozansan.sanweather.util

data class WeatherInfo(
    val description: String,
    val imageUrl: String
)

object WeatherCodeMapper {
    private val weatherMap: Map<Int, Pair<WeatherInfo, WeatherInfo>> = mapOf(
        0 to Pair(WeatherInfo("Sunny", "http://openweathermap.org/img/wn/01d@2x.png"), WeatherInfo("Clear", "http://openweathermap.org/img/wn/01n@2x.png")),
        1 to Pair(WeatherInfo("Mainly Sunny", "http://openweathermap.org/img/wn/01d@2x.png"), WeatherInfo("Mainly Clear", "http://openweathermap.org/img/wn/01n@2x.png")),
        2 to Pair(WeatherInfo("Partly Cloudy", "http://openweathermap.org/img/wn/02d@2x.png"), WeatherInfo("Partly Cloudy", "http://openweathermap.org/img/wn/02n@2x.png")),
        3 to Pair(WeatherInfo("Cloudy", "http://openweathermap.org/img/wn/03d@2x.png"), WeatherInfo("Cloudy", "http://openweathermap.org/img/wn/03n@2x.png")),
        45 to Pair(WeatherInfo("Foggy", "http://openweathermap.org/img/wn/50d@2x.png"), WeatherInfo("Foggy", "http://openweathermap.org/img/wn/50n@2x.png")),
        48 to Pair(WeatherInfo("Rime Fog", "http://openweathermap.org/img/wn/50d@2x.png"), WeatherInfo("Rime Fog", "http://openweathermap.org/img/wn/50n@2x.png")),
        51 to Pair(WeatherInfo("Light Drizzle", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Light Drizzle", "http://openweathermap.org/img/wn/09n@2x.png")),
        53 to Pair(WeatherInfo("Drizzle", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Drizzle", "http://openweathermap.org/img/wn/09n@2x.png")),
        55 to Pair(WeatherInfo("Heavy Drizzle", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Heavy Drizzle", "http://openweathermap.org/img/wn/09n@2x.png")),
        56 to Pair(WeatherInfo("Light Freezing Drizzle", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Light Freezing Drizzle", "http://openweathermap.org/img/wn/09n@2x.png")),
        57 to Pair(WeatherInfo("Freezing Drizzle", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Freezing Drizzle", "http://openweathermap.org/img/wn/09n@2x.png")),
        61 to Pair(WeatherInfo("Light Rain", "http://openweathermap.org/img/wn/10d@2x.png"), WeatherInfo("Light Rain", "http://openweathermap.org/img/wn/10n@2x.png")),
        63 to Pair(WeatherInfo("Rain", "http://openweathermap.org/img/wn/10d@2x.png"), WeatherInfo("Rain", "http://openweathermap.org/img/wn/10n@2x.png")),
        65 to Pair(WeatherInfo("Heavy Rain", "http://openweathermap.org/img/wn/10d@2x.png"), WeatherInfo("Heavy Rain", "http://openweathermap.org/img/wn/10n@2x.png")),
        66 to Pair(WeatherInfo("Light Freezing Rain", "http://openweathermap.org/img/wn/10d@2x.png"), WeatherInfo("Light Freezing Rain", "http://openweathermap.org/img/wn/10n@2x.png")),
        67 to Pair(WeatherInfo("Freezing Rain", "http://openweathermap.org/img/wn/10d@2x.png"), WeatherInfo("Freezing Rain", "http://openweathermap.org/img/wn/10n@2x.png")),
        71 to Pair(WeatherInfo("Light Snow", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Light Snow", "http://openweathermap.org/img/wn/13n@2x.png")),
        73 to Pair(WeatherInfo("Snow", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Snow", "http://openweathermap.org/img/wn/13n@2x.png")),
        75 to Pair(WeatherInfo("Heavy Snow", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Heavy Snow", "http://openweathermap.org/img/wn/13n@2x.png")),
        77 to Pair(WeatherInfo("Snow Grains", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Snow Grains", "http://openweathermap.org/img/wn/13n@2x.png")),
        80 to Pair(WeatherInfo("Light Showers", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Light Showers", "http://openweathermap.org/img/wn/09n@2x.png")),
        81 to Pair(WeatherInfo("Showers", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Showers", "http://openweathermap.org/img/wn/09n@2x.png")),
        82 to Pair(WeatherInfo("Heavy Showers", "http://openweathermap.org/img/wn/09d@2x.png"), WeatherInfo("Heavy Showers", "http://openweathermap.org/img/wn/09n@2x.png")),
        85 to Pair(WeatherInfo("Light Snow Showers", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Light Snow Showers", "http://openweathermap.org/img/wn/13n@2x.png")),
        86 to Pair(WeatherInfo("Snow Showers", "http://openweathermap.org/img/wn/13d@2x.png"), WeatherInfo("Snow Showers", "http://openweathermap.org/img/wn/13n@2x.png")),
        95 to Pair(WeatherInfo("Thunderstorm", "http://openweathermap.org/img/wn/11d@2x.png"), WeatherInfo("Thunderstorm", "http://openweathermap.org/img/wn/11n@2x.png")),
        96 to Pair(WeatherInfo("Light Thunderstorms With Hail", "http://openweathermap.org/img/wn/11d@2x.png"), WeatherInfo("Light Thunderstorms With Hail", "http://openweathermap.org/img/wn/11n@2x.png")),
        99 to Pair(WeatherInfo("Thunderstorm With Hail", "http://openweathermap.org/img/wn/11d@2x.png"), WeatherInfo("Thunderstorm With Hail", "http://openweathermap.org/img/wn/11n@2x.png"))
    )

    fun getWeatherInfo(code: Int, isDay: Int): WeatherInfo {
        val infoPair = weatherMap[code] ?: return WeatherInfo("Unknown", "")
        return if (isDay == 1) infoPair.first else infoPair.second
    }
}
