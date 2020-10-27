package com.example.restaurantfinder

import android.content.Context
import com.example.restaurantfinder.persistence.RestaurantDao
import com.example.restaurantfinder.persistence.RestaurantsDatabase

object Injection {

    fun provideRestaurantDataSource(context: Context): RestaurantDao {
        val database = RestaurantsDatabase.getInstance(context)
        return database.restaurantDao()
    }

//    fun provideViewModelFactory(context: Context): ViewModelFactory {
//        val dataSource = provideRestaurantDataSource(context)
//        return ViewModelFactory(dataSource)
//    }
}