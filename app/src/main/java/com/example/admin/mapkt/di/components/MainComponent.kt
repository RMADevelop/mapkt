package com.example.admin.mapkt.di.components

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.admin.mapkt.R
import com.example.admin.mapkt.di.scopes.ActivityScope
import com.example.admin.mapkt.presentatioin.main.MainActivity
import com.example.admin.mapkt.presentatioin.main.MainNavigator
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Navigator

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun plusWeatherInfoComponent(): WeatherInfoComponent

    fun plusMapComponent(): MapComponent

    fun plusSplashComponent(): SplashComponent
}

@Module
class MainModule(private var fragmentActivity: FragmentActivity,
                 private var fragmentManager: FragmentManager) {

    @Provides
    @ActivityScope
    fun provideNavigator(): Navigator = MainNavigator(fragmentActivity, fragmentManager, R.id.container)
}

