package com.devika.atgcodechallenge.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import javax.inject.Inject

class NetworkManager @Inject constructor(private val context: Context?) {
    fun isNetworkAvailable(): Boolean {
        var result = false
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                result = when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

                    else -> false
                }
            }
        }
        return result
    }
}