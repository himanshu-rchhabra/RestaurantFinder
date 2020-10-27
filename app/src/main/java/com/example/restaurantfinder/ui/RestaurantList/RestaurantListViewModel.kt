package com.example.restaurantfinder.ui.RestaurantList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantfinder.persistence.RestaurantDao

class RestaurantListViewModel(private val database: RestaurantDao) : ViewModel() {


    open class Factory(private val db: RestaurantDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(database = this.db) as T
        }
    }
}