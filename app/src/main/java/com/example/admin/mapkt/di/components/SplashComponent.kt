package com.example.admin.mapkt.di.components

import com.example.admin.mapkt.presentatioin.splash.SplashPresenter
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {

    fun splashPresenter(): SplashPresenter
}

@Module
class SplashModule {

//    @Provides
//    @FragmentScope
//fun provide
}