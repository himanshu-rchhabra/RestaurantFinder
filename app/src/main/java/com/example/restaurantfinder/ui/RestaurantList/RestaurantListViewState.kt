package com.example.restaurantfinder.ui.RestaurantList

import com.example.restaurantfinder.persistence.Restaurant

data class RestaurantListViewState(
    var isLoading: Boolean = true,
    var error: Throwable? = null,
    var restaurants: List<Restaurant>? = null
) {

    fun onError(error: Throwable?): RestaurantListViewState {
        return copy(
            isLoading = false,
            error = error
        )
    }

    fun onDataLoaded(data: List<Restaurant>): RestaurantListViewState {
        return copy(
            isLoading = false,
            error = null,
            restaurants = data
        )
    }

    fun onLoading(): RestaurantListViewState {
        return copy(
            isLoading = true
        )
    }
}