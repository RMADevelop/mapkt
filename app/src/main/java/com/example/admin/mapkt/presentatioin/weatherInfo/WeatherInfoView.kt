package com.example.admin.mapkt.presentatioin.weatherInfo

import com.arellomobile.mvp.MvpView
import com.example.admin.mapkt.data.local.entity.Location
import com.example.admin.mapkt.domain.models.Weather

interface WeatherInfoView : MvpView {
    fun showWeather(weather: Weather)
    fun showLocation(it: Location)
}