package com.example.admin.mapkt.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(context: Context) {

    private val context: Context = context

    @Provides
    @Singleton
    fun provideApplicationContext() = context
}