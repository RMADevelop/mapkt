package com.example.admin.mapkt.utils

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import io.reactivex.*

class FusedLocationProviderSingle(
        private val client: FusedLocationProviderClient
) : SingleOnSubscribe<Location> {

    companion object {
        fun create(client: FusedLocationProviderClient): Single<Location> =
                Single.defer { Single.create(FusedLocationProviderSingle(client)) }

    }

    @SuppressLint("MissingPermission")
    override fun subscribe(emitter: SingleEmitter<Location>) {
        with(client.lastLocation) {
            addOnSuccessListener {
                if (it != null) {
                    emitter.onSuccess(it)
                } else {
                    emitter.onError(Throwable())
                }
            }
            addOnFailureListener {
                emitter.onError(it)
            }
        }

    }
}

class FusedLocationProviderObserver(
        private val client: FusedLocationProviderClient,
        private val request: LocationRequest
) : ObservableOnSubscribe<Location> {
    companion object {
        fun create(client: FusedLocationProviderClient, request: LocationRequest) =
                Observable.defer { Observable.create(FusedLocationProviderObserver(client, request)) }
    }

    @SuppressLint("MissingPermission")
    override fun subscribe(emitter: ObservableEmitter<Location>) {
        val callback = Callback(emitter)

        client.requestLocationUpdates(request, callback, null)
        client.flushLocations()

    }

    private class Callback(val emmiter: ObservableEmitter<Location>) : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            if (result.lastLocation != null) {
                emmiter.onNext(result.lastLocation)
            }
        }
    }


}