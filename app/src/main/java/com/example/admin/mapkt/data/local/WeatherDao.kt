package com.example.admin.mapkt.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import com.example.admin.mapkt.data.local.entity.WeatherEntity

@Dao
interface WeatherDao {

    @Insert
    fun insertWeather(weatherEntity: WeatherEntity)

    @Delete
    fun delete(weatherEntity: WeatherEntity)

//    @Query("SELECT * FROM 'weather_wrapper' WHERE " )
}