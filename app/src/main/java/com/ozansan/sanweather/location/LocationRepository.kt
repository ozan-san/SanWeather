package com.ozansan.sanweather.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val fusedLocationClient: FusedLocationProviderClient
) {

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(): Flow<Location> = callbackFlow {
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(5000)
            .build()

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.lastLocation?.let { location ->
                    trySend(location)
                }
            }
        }

        if (hasLocationPermission()) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        } else {
            close(Exception("Location permission not granted"))
        }

        awaitClose { fusedLocationClient.removeLocationUpdates(locationCallback) }
    }

    fun getCityName(latitude: Double, longitude: Double): String? {
        val geocoder = Geocoder(context, Locale.getDefault())
        return try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            addresses?.firstOrNull()?.locality ?: addresses?.firstOrNull()?.adminArea
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
    }
}