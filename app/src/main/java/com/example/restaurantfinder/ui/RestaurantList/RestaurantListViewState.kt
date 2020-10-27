package com.example.restaurantfinder.ui.RestaurantList

import com.example.restaurantfinder.persistence.Restaurant

data class RestaurantListViewState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val restaurants: List<Restaurant>? = null
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