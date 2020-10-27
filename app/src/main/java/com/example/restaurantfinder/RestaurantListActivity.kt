package com.example.restaurantfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantfinder.ui.RestaurantDetails.RestaurantDetailActivity
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListAdapter
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_loading_try_again.*

class RestaurantListActivity : AppCompatActivity(),
    RestaurantListAdapter.RestaurantListClickListener {

    // TODO Milestone1 (10) User RestaurantListViewModel to fetch data
    private lateinit var viewModelFactory: RestaurantListViewModel.Factory
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RestaurantListAdapter

    private val viewModel: RestaurantListViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try_again.setOnClickListener { viewModel.loadData() }

        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantListAdapter(restaurantListClickListener = this)
        restaurants_recycler_view.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
        viewModelFactory = Injection.provideRestaurantListViewModelFactory(this)

        viewModel.getLiveData().observe(this, Observer {
            renderState(it)
        })
        viewModel.loadData()
    }

    // TODO Milestone1 (12) Render state from api response
    private fun renderState(viewState: RestaurantListViewState) {
        when {
            viewState.isLoading -> renderLoadingState()
            viewState.error != null -> renderErrorState()
            else -> renderData(viewState)
        }
    }

    private fun renderLoadingState() {
        loading_text.visibility = View.VISIBLE
        error_loading.visibility = View.GONE
        restaurants_recycler_view.visibility = View.GONE
    }

    private fun renderErrorState() {
        loading_text.visibility = View.GONE
        error_loading.visibility = View.VISIBLE
        restaurants_recycler_view.visibility = View.GONE
    }

    private fun renderData(viewState: RestaurantListViewState) {
        loading_text.visibility = View.GONE
        error_loading.visibility = View.GONE
        restaurants_recycler_view.visibility = View.VISIBLE

        viewAdapter.setData(viewState.restaurants!!)
    }

    override fun onRestaurantClicked(restaurantId: Int) {
        startActivity(RestaurantDetailActivity.newIntent(this, restaurantId))
    }
}