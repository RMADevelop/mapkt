package com.example.admin.mapkt.utils

import android.content.Context
import com.example.admin.mapkt.data.local.entity.Location
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import io.reactivex.Observable
import io.reactivex.Single

class LocationProviderCustom constructor(
        val context: Context
) {

    private val client = LocationServices.getFusedLocationProviderClient(context)
    private val request = LocationRequest.create()

    init {
        request.interval = 60000L
        request.fastestInterval = 30000L
        request.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(request)
        val settings = builder.build()
        val settingClient = LocationServices.getSettingsClient(context)
        settingClient.checkLocationSettings(settings)
    }

    fun getLocations(): Single<Location> =
            FusedLocationProviderSingle
                    .create(client)
                    .map { Location(it.latitude, it.longitude) }

    fun getLocationObserve(): Observable<Location> =
            FusedLocationProviderObserver
                    .create(client, request)
                    .map { Location(it.latitude, it.longitude) }

}