package com.example.admin.mapkt.domain.weatherInfo

import com.example.admin.mapkt.domain.models.Weather
import com.example.admin.mapkt.domain.repository.LocationRepository
import com.example.admin.mapkt.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherInfoInteractor /*@Inject */ constructor(
        private val weatherRepository: WeatherRepository,
        private val locationRepository: LocationRepository
) : WeatherInteractor {
    override fun getLocationOnce() =
            locationRepository.getCurrentLocation()


    override fun getLocationObserver() =
            locationRepository.getLocationObservable()


    override fun getWeatherInfo(lat: Double, lon: Double): Single<Weather> =
            weatherRepository.getWeather(lat, lon)
}