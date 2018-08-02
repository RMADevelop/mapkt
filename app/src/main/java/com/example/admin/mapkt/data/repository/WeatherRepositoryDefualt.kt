package com.example.admin.mapkt.data.repository

import com.example.admin.mapkt.data.Server
import com.example.admin.mapkt.data.local.WeatherDao
import com.example.admin.mapkt.data.remote.dto.WeatherDtoMapper
import com.example.admin.mapkt.domain.models.Weather
import com.example.admin.mapkt.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepositoryDefualt @Inject constructor(
        /*val weatherDao: WeatherDao,*/
        private val server: Server,
        private val weatherDtoMapper: WeatherDtoMapper
) : WeatherRepository {
    override fun saveWeather(weather: Weather) {

    }

    override fun getWeather(latitude: Double, longitude: Double): Single<Weather> =
            server.loadWeather(lat = latitude, lon = longitude)
                    .map { weatherDtoMapper.map(it) }
}