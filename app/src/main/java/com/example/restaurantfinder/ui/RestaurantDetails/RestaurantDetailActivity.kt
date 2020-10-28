package com.example.restaurantfinder.ui.RestaurantDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantfinder.Injection
import com.example.restaurantfinder.R
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListAdapter
import com.example.restaurantfinder.ui.RestaurantList.RestaurantListViewModel
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

// TODO Milestone4 (01) Create RestaurantDetailActivity
class RestaurantDetailActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: RestaurantDetailViewModel.Factory
    private val viewModel: RestaurantDetailViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        viewModelFactory = Injection.provideRestaurantDetailViewModelFactory(this)

        val restaurantId = intent.getIntExtra(RESTAURANT_ID, 0)
        viewModel.getLiveData().observe(this, Observer {
            renderState(it)
        })
        viewModel.loadData(restaurantId)
    }

    // TODO Milestone4 (08) Show restaurant details in the RestaurantDetailActivity
    private fun renderState(viewState: BroadcastDetailViewState) {
        when {
            viewState.isLoading -> showLoadingState()
            viewState.error != null -> showErrorState()
            else -> showDataState(viewState)
        }
    }

    private fun showLoadingState() {
        loading_text.visibility = View.VISIBLE
        error_loading.visibility = View.GONE
        restaurant_details.visibility = View.GONE
    }

    private fun showErrorState() {
        loading_text.visibility = View.GONE
        error_loading.visibility = View.VISIBLE
        restaurant_details.visibility = View.GONE
    }

    private fun showDataState(viewState: BroadcastDetailViewState) {
        loading_text.visibility = View.GONE
        error_loading.visibility = View.GONE
        restaurant_details.visibility = View.VISIBLE

        viewState.restaurant?.let {
            restaurant_name.text = it.name
            restaurant_cuisine.text = it.cuisines
            Glide.with(restaurant_cover.context)
                .load(it.featuredImage)
                .optionalCenterCrop()
                .into(restaurant_cover)
            restaurant_timings.text = it.timings
            restaurant_avg_cost.text = it.currency + it.costForTwo
        }
    }

    companion object {
        private const val RESTAURANT_ID = "restaurant_id"
        fun newIntent(context: Context, restaurantId: Int): Intent {
            return Intent(context, RestaurantDetailActivity::class.java).apply {
                putExtra(RESTAURANT_ID, restaurantId)
            }
        }
    }
}