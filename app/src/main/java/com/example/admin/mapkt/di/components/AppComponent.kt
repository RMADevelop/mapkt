package com.example.admin.mapkt.di.components

import com.example.admin.mapkt.di.modules.ApplicationModule
import com.example.admin.mapkt.di.modules.NavigationModule
import com.example.admin.mapkt.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NavigationModule::class,
    NetworkModule::class]
)
interface AppComponent {

    fun plusMainComponent(mainModule: MainModule): MainComponent
}