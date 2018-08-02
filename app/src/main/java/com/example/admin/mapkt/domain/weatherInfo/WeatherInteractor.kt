package com.example.admin.mapkt.domain.weatherInfo

import com.example.admin.mapkt.data.local.entity.Location
import com.example.admin.mapkt.domain.models.Weather
import io.reactivex.Observable
import io.reactivex.Single

interface WeatherInteractor {

    fun getWeatherInfo(lat: Double, lon: Double): Single<Weather>

    fun getLocationOnce(): Single<Location>

    fun getLocationObserver(): Observable<Location>
}