package com.example.restaurantfinder.ui.RestaurantList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.persistence.RestaurantDao

class RestaurantListViewModel(
    private val database: RestaurantDao,
    private val api: ZomatoApi
) : ViewModel() {


    open class Factory(
        private val database: RestaurantDao,
        private val api: ZomatoApi
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(
                database = this.database,
                api = this.api
            ) as T
        }
    }
}