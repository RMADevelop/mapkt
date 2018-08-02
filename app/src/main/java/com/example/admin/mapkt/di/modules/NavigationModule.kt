package com.example.admin.mapkt.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Singleton

@Module
class NavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter() = cicerone.router

    @Provides
    @Singleton
    fun providenavigatorHolder() = cicerone.navigatorHolder
}