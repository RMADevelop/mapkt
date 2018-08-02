package com.example.admin.mapkt.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "weather_wrapper")
data class WeatherEntity(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "time") val nowTime: Long
)

@Entity(tableName = "place",
        foreignKeys = [
            ForeignKey(
                    entity = WeatherEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["weather_entity_id"],
                    onDelete = ForeignKey.CASCADE
            )])
data class InfoPlaceData(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "latitude") val lat: Double,
        @ColumnInfo(name = "longitude") val lon: Double,
        @ColumnInfo(name = "url") val urlPlace: String,

        @ColumnInfo(name = "weather_entity_id") val idWeatherEntity: Int
)

@Entity(tableName = "weather_info",
        foreignKeys = [
            ForeignKey(
                    entity = WeatherEntity::class,
                    parentColumns = ["id"],
                    childColumns = ["weather_entity_id"],
                    onDelete = ForeignKey.CASCADE
            )]
)
data class FactWeatherData(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "temperature") val temperatureFact: Double,
        @ColumnInfo(name = "feels_like") val temperatureFeelsDouble: Double,
        @ColumnInfo(name = "icon") val iconUrl: String,
        @ColumnInfo(name = "condition") val condition: String,
        @ColumnInfo(name = "wind_speed") val windSpeed: Double,
        @ColumnInfo(name = "wind_gust") val windGust: Double,
        @ColumnInfo(name = "wind_dir") val windDir: String,
        @ColumnInfo(name = "humidity") val humidity: Double,
        @ColumnInfo(name = "season") val season: String,
        @ColumnInfo(name = "daytime") val daytime: String,

        @ColumnInfo(name = "weather_entity_id") val idWeatherEntity: Int
)