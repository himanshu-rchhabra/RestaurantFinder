package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

object Injection {
    // TODO Milestone3 (05) add injection for database

    fun provideRestaurantListViewModelFactory(context: Context): RestaurantListViewModel.Factory {
        val apiSource = ZomatoApi.create()
        return RestaurantListViewModel.Factory(
            api = apiSource
        )
    }
}