package com.example.admin.mapkt.di.components

import android.content.Context
import com.example.admin.mapkt.data.Server
import com.example.admin.mapkt.data.remote.dto.WeatherDtoMapper
import com.example.admin.mapkt.data.repository.LocationRepositoryDefualt
import com.example.admin.mapkt.data.repository.WeatherRepositoryDefualt
import com.example.admin.mapkt.di.scopes.FragmentScope
import com.example.admin.mapkt.domain.repository.LocationRepository
import com.example.admin.mapkt.domain.repository.WeatherRepository
import com.example.admin.mapkt.domain.weatherInfo.WeatherInfoInteractor
import com.example.admin.mapkt.domain.weatherInfo.WeatherInteractor
import com.example.admin.mapkt.presentatioin.weatherInfo.WeatherInfoFragment
import com.example.admin.mapkt.presentatioin.weatherInfo.WeatherInfoPresenter
import com.example.admin.mapkt.utils.LocationProviderCustom
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [WeatherInfoModule::class])
interface WeatherInfoComponent {

    fun inject(weatherInfoFragment: WeatherInfoFragment)

    fun presenter(): WeatherInfoPresenter

}

@Module
class WeatherInfoModule {

    @Provides
    @FragmentScope
    fun provideWeatherRepository(/*weeatherDao: WeatherDao,*/ server: Server, weatherDtoMapper: WeatherDtoMapper): WeatherRepository =
            WeatherRepositoryDefualt(/*weeatherDao, */server, weatherDtoMapper)

    @Provides
    @FragmentScope
    fun provideLocationRepository(locationProviderCustom: LocationProviderCustom): LocationRepository =
            LocationRepositoryDefualt(locationProviderCustom)

    @Provides
    @FragmentScope
    fun provideInteractor(weaterRepository: WeatherRepository, locationRepository: LocationRepository): WeatherInteractor =
            WeatherInfoInteractor(weaterRepository, locationRepository)

    @Provides
    @FragmentScope
    fun provideLocationProvider(context: Context) =
            LocationProviderCustom(context)
}
