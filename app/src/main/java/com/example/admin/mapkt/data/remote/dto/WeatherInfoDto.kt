package com.example.admin.mapkt.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherInfoDto(
        @SerializedName("now") val nowTime: Long,
        @SerializedName("now_dt") val nowTimeDt: String,
        @SerializedName("info") val infoPlaceDto: InfoPlaceDto,
        @SerializedName("fact") val factWeatherDto: FactWeatherDto
//        @SerializedName("forecasts") val forecastWeather: ForecastWeather
)

data class InfoPlaceDto(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lon") val lon: Double,
        @SerializedName("url") val urlPlace: String
)

data class FactWeatherDto(
        @SerializedName("temp") val temperatureFact: Double,
        @SerializedName("feels_like") val temperatureFeelsDouble: Double,
        @SerializedName("icon") val iconUrl: String,
        @SerializedName("condition") val condition: String,
        @SerializedName("wind_speed") val windSpeed: Double,
        @SerializedName("wind_gust") val windGust: Double,
        @SerializedName("wind_dir") val windDir: String,
        @SerializedName("humidity") val humidity: Double,
        @SerializedName("season") val season: String,
        @SerializedName("daytime") val daytime: String
)