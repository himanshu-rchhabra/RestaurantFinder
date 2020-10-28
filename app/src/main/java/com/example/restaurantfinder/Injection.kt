package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.persistence.RestaurantDao
import com.example.restaurantfinder.persistence.RestaurantsDatabase
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

object Injection {
    private fun provideRestaurantDataSource(context: Context): RestaurantDao {
        val database = RestaurantsDatabase.getInstance(context)
        return database.restaurantDao()
    }

    fun provideRestaurantListViewModelFactory(context: Context): RestaurantListViewModel.Factory {
        val database = provideRestaurantDataSource(context)
        val apiSource = ZomatoApi.create()
        return RestaurantListViewModel.Factory(
            api = apiSource,
            database = database
        )
    }

    // TODO Milestone4 (07) Create Injection for restaurant detail viewmodel factory
}