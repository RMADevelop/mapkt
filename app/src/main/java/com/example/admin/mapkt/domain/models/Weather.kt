package com.example.admin.mapkt.domain.models

data class Weather(
        val nowTime: Long,
        val nowTimeDt: String,
        val infoPlaceDto: InfoPlace,
        val factWeatherDto: FactWeather
)

data class InfoPlace(
        val lat: Double,
        val lon: Double,
        val urlPlace: String
)

data class FactWeather(
        val temperatureFact: Double,
        val temperatureFeelsDouble: Double,
        val iconUrl: String,
        val condition: String,
        val windSpeed: Double,
        val windGust: Double,
        val windDir: String,
        val humidity: Double,
        val season: String,
        val daytime: String
)