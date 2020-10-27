package com.example.restaurantfinder

import android.app.Application
import com.facebook.stetho.Stetho

class RestaurantFinderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}