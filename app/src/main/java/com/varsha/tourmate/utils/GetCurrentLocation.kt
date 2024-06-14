package com.varsha.tourmate.utils

import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task

fun getCurrentLocation(context: Context, callback: (Location?) -> Unit) {
    val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    try {
        fusedLocationClient.lastLocation.addOnCompleteListener { task: Task<Location> ->
            if (task.isSuccessful && task.result != null) {
                callback(task.result)
            } else {
                callback(null)
            }
        }
    } catch (e: SecurityException) {
        callback(null)
    }
}
