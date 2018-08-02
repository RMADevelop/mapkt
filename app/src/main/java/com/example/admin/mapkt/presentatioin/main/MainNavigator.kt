package com.example.admin.mapkt.presentatioin.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.admin.mapkt.presentatioin.Screens
import com.example.admin.mapkt.presentatioin.core.BaseNavigator
import com.example.admin.mapkt.presentatioin.weatherInfo.WeatherInfoFragment
import javax.inject.Inject

class MainNavigator @Inject constructor(fragmentActivity: FragmentActivity,
                                        fragmentManager: FragmentManager,
                                        containerInt: Int
) : BaseNavigator(fragmentActivity, fragmentManager, containerInt) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment =
            when (screenKey) {
                Screens.SPLASH_SCREEN_KEY -> throw IllegalArgumentException("todo")
                Screens.WEATHER_INFO_SCREEN_KEY -> WeatherInfoFragment.newInstance()
                else -> throw IllegalArgumentException("illegal key $screenKey")
            }
}