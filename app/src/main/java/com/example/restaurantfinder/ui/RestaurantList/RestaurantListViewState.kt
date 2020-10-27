package com.example.restaurantfinder.ui.RestaurantList

import com.example.restaurantfinder.persistence.Restaurant

data class RestaurantListViewState(
    val isLoading: Boolean = true,
    val error: Throwable? = null,
    val restaurants: List<Restaurant>? = null
)