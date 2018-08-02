package com.example.admin.mapkt.data.remote.dto

import com.example.admin.mapkt.domain.Mapper
import com.example.admin.mapkt.domain.models.FactWeather
import com.example.admin.mapkt.domain.models.InfoPlace
import com.example.admin.mapkt.domain.models.Weather
import javax.inject.Inject

class WeatherDtoMapper @Inject constructor(
        private val infoPlaceDtoMapper: InfoPlaceDtoMapper,
        private val factWeatherDtoMapper: FactWeatherDtoMapper
) : Mapper<WeatherInfoDto, Weather> {


    override fun map(from: WeatherInfoDto): Weather =
            Weather(
                    from.nowTime,
                    from.nowTimeDt,
                    infoPlaceDtoMapper.map(from.infoPlaceDto),
                    factWeatherDtoMapper.map(from.factWeatherDto)
            )

    override fun map(list: List<WeatherInfoDto>): List<Weather> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class InfoPlaceDtoMapper @Inject constructor() : Mapper<InfoPlaceDto, InfoPlace> {

    override fun map(from: InfoPlaceDto): InfoPlace = InfoPlace(
            from.lat,
            from.lon,
            from.urlPlace
    )

    override fun map(list: List<InfoPlaceDto>): List<InfoPlace> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class FactWeatherDtoMapper @Inject constructor() : Mapper<FactWeatherDto, FactWeather> {
    override fun map(from: FactWeatherDto): FactWeather =
            FactWeather(
                    from.temperatureFact,
                    from.temperatureFeelsDouble,
                    from.iconUrl,
                    from.condition,
                    from.windSpeed,
                    from.windGust,
                    from.windDir,
                    from.humidity,
                    from.season,
                    from.daytime
            )

    override fun map(list: List<FactWeatherDto>): List<FactWeather> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}