package com.example.admin.mapkt.data

import com.example.admin.mapkt.data.remote.dto.WeatherInfoDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Server {
    @GET("v1/informers")
    fun loadWeather(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double
    ): Single<WeatherInfoDto>
}