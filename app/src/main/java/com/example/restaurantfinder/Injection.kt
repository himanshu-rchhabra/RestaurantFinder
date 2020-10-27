package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

object Injection {

    fun provideRestaurantListViewModelFactory(context: Context): RestaurantListViewModel.Factory {
        val apiSource = ZomatoApi.create()
        return RestaurantListViewModel.Factory(
            api = apiSource
        )
    }
}