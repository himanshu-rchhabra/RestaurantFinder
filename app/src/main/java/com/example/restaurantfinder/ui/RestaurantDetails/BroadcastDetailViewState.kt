package com.example.restaurantfinder.ui.RestaurantDetails

import com.example.restaurantfinder.persistence.Restaurant

data class BroadcastDetailViewState(
    var isLoading: Boolean = true,
    var error: Throwable? = null,
    var restaurant: Restaurant? = null
) {
    fun onError(error: Throwable?): BroadcastDetailViewState {
        return copy(
            isLoading = false,
            error = error
        )
    }

    fun onLoading(): BroadcastDetailViewState {
        return copy(
            isLoading = true
        )
    }

    fun onDataLoaded(restaurant: Restaurant): BroadcastDetailViewState {
        return copy(
            isLoading = false,
            error = null,
            restaurant = restaurant
        )
    }
}