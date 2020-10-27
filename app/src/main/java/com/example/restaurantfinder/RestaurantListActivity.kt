package com.example.restaurantfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel

class RestaurantListActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: RestaurantListViewModel.Factory

    private val viewModel: RestaurantListViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}