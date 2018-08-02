package com.example.admin.mapkt.data.repository

import com.example.admin.mapkt.data.local.entity.Location
import com.example.admin.mapkt.domain.repository.LocationRepository
import com.example.admin.mapkt.utils.LocationProviderCustom
import io.reactivex.Observable
import io.reactivex.Single

class LocationRepositoryDefualt(
        val locationProvider: LocationProviderCustom
) : LocationRepository {

    override fun getCurrentLocation(): Single<Location> =
            locationProvider.getLocations()

    override fun getLocationObservable(): Observable<Location> =
            locationProvider.getLocationObserve()
}