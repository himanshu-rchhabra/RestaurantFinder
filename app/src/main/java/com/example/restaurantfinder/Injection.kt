package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.persistence.RestaurantDao
import com.example.restaurantfinder.persistence.RestaurantsDatabase
import com.example.restaurantfinder.ui.RestaurantDetails.RestaurantDetailViewModel
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

object Injection {

    // TODO Milestone3 (05) add injection for database
    private fun provideRestaurantDataSource(context: Context): RestaurantDao {
        val database = RestaurantsDatabase.getInstance(context)
        return database.restaurantDao()
    }

    // TODO Milestone1 (09) Define injection for RestaurantListViewModel
    fun provideRestaurantListViewModelFactory(context: Context): RestaurantListViewModel.Factory {
        val database = provideRestaurantDataSource(context)
        val apiSource = ZomatoApi.create()
        return RestaurantListViewModel.Factory(
            database = database,
            api = apiSource
        )
    }

    // TODO Milestone4 (07) Create Injection for restaurant detail viewmodel factory
    fun provideRestaurantDetailViewModelFactory(context: Context): RestaurantDetailViewModel.Factory {
        val database = provideRestaurantDataSource(context)
        return RestaurantDetailViewModel.Factory(
            database = database
        )
    }
}