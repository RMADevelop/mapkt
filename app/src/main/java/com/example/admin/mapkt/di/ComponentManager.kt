package com.example.admin.mapkt.di

import android.app.Application
import com.example.admin.mapkt.di.components.AppComponent
import com.example.admin.mapkt.di.components.DaggerAppComponent
import com.example.admin.mapkt.di.components.MainComponent
import com.example.admin.mapkt.di.components.MainModule
import com.example.admin.mapkt.di.modules.ApplicationModule

object ComponentManager {

    lateinit var appComponent: AppComponent
    lateinit var mainComponent: MainComponent

    fun initComponentManager(application: Application) {
        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build()
    }

    fun plusMainComponent(mainModule: MainModule): MainComponent {
        mainComponent = appComponent.plusMainComponent(mainModule)
        return mainComponent
    }

    fun plusWeatherInfoComponent() = mainComponent.plusWeatherInfoComponent()

    fun plusSplashComponent() = mainComponent.plusSplashComponent()

    fun plusMapComponent() = mainComponent.plusSplashComponent()
}