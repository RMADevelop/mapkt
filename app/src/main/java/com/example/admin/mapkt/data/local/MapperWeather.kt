package com.example.admin.mapkt.data.local

import com.example.admin.mapkt.data.local.entity.WeatherEntity
import com.example.admin.mapkt.domain.Mapper
import com.example.admin.mapkt.domain.models.Weather

class MapperWeather : Mapper<WeatherEntity, Weather> {
    override fun map(from: WeatherEntity): Weather {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun map(list: List<WeatherEntity>): List<Weather> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}