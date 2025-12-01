package com.ozansan.sanweather.network

enum class WeatherType {
    CLEAR_SKY,
    MAINLY_CLEAR,
    PARTLY_CLOUDY,
    OVERCAST,
    FOG,
    DEPOSITING_RIME_FOG,
    DRIZZLE_LIGHT,
    DRIZZLE_MODERATE,
    DRIZZLE_DENSE,
    FREEZING_DRIZZLE_LIGHT,
    FREEZING_DRIZZLE_DENSE,
    RAIN_SLIGHT,
    RAIN_MODERATE,
    RAIN_HEAVY,
    FREEZING_RAIN_LIGHT,
    FREEZING_RAIN_HEAVY,
    SNOWFALL_SLIGHT,
    SNOWFALL_MODERATE,
    SNOWFALL_HEAVY,
    SNOW_GRAINS,
    RAIN_SHOWERS_SLIGHT,
    RAIN_SHOWERS_MODERATE,
    RAIN_SHOWERS_VIOLENT,
    SNOW_SHOWERS_SLIGHT,
    SNOW_SHOWERS_HEAVY,
    THUNDERSTORM,
    THUNDERSTORM_WITH_HAIL,
    UNKNOWN;

    companion object {
        fun fromWmoCode(code: Int): WeatherType {
            return when(code) {
                0 -> CLEAR_SKY
                1 -> MAINLY_CLEAR
                2 -> PARTLY_CLOUDY
                3 -> OVERCAST
                45 -> FOG
                48 -> DEPOSITING_RIME_FOG
                51 -> DRIZZLE_LIGHT
                53 -> DRIZZLE_MODERATE
                55 -> DRIZZLE_DENSE
                56 -> FREEZING_DRIZZLE_LIGHT
                57 -> FREEZING_DRIZZLE_DENSE
                61 -> RAIN_SLIGHT
                63 -> RAIN_MODERATE
                65 -> RAIN_HEAVY
                66 -> FREEZING_RAIN_LIGHT
                67 -> FREEZING_RAIN_HEAVY
                71 -> SNOWFALL_SLIGHT
                73 -> SNOWFALL_MODERATE
                75 -> SNOWFALL_HEAVY
                77 -> SNOW_GRAINS
                80 -> RAIN_SHOWERS_SLIGHT
                81 -> RAIN_SHOWERS_MODERATE
                82 -> RAIN_SHOWERS_VIOLENT
                85 -> SNOW_SHOWERS_SLIGHT
                86 -> SNOW_SHOWERS_HEAVY
                95 -> THUNDERSTORM
                96, 99 -> THUNDERSTORM_WITH_HAIL
                else -> UNKNOWN
            }
        }
    }
}