package com.example.admin.mapkt

import android.app.Application
import com.example.admin.mapkt.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.initComponentManager(this)
    }
}