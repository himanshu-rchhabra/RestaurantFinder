package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.persistence.RestaurantDao
import com.example.restaurantfinder.persistence.RestaurantsDatabase
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

object Injection {

    fun provideRestaurantDataSource(context: Context): RestaurantDao {
        val database = RestaurantsDatabase.getInstance(context)
        return database.restaurantDao()
    }

    fun provideRestaurantListViewModelFactory(context: Context): RestaurantListViewModel.Factory {
        val dataSource = provideRestaurantDataSource(context)
        return RestaurantListViewModel.Factory(dataSource)
    }
}