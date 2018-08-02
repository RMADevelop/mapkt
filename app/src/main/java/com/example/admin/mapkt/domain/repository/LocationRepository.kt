package com.example.admin.mapkt.domain.repository

import com.example.admin.mapkt.data.local.entity.Location
import io.reactivex.Observable
import io.reactivex.Single

interface LocationRepository {
    fun getCurrentLocation(): Single<Location>

    fun getLocationObservable(): Observable<Location>
}