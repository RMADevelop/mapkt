package com.example.admin.mapkt.di.components

import android.content.Context
import com.example.admin.mapkt.di.scopes.FragmentScope
import com.example.admin.mapkt.utils.LocationProviderCustom
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [MapModule::class])
interface MapComponent {


}

@Module
class MapModule {

    @Provides
    @FragmentScope
    fun provideLocationProvider(context: Context) =
            LocationProviderCustom(context)
}