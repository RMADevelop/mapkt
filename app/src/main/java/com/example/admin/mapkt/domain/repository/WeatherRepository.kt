package com.example.admin.mapkt.domain.repository

import com.example.admin.mapkt.domain.models.Weather
import io.reactivex.Single

interface WeatherRepository {

    fun getWeather(latitude: Double, longitude: Double): Single<Weather>

    fun saveWeather(weather: Weather)
}