package com.example.restaurantfinder.ui.RestaurantList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantfinder.R
import com.example.restaurantfinder.persistence.Restaurant

class RestaurantListAdapter(
    private var restaurantList: List<Restaurant> = emptyList()
) :
    RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_item_row, parent, false)

        return ViewHolder(v)
    }

    fun setData(data: List<Restaurant>) {
        restaurantList = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: RestaurantListAdapter.ViewHolder, position: Int) {
        holder.bindView(restaurantList[position])
    }

    open class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val name: TextView
        private val cuisine: TextView
        private val image: ImageView

        // TODO Milestone4 (02) Launch RestaurantDetailActivity when a restaurant is selected from the list
        fun bindView(restaurant: Restaurant) {
            name.text = restaurant.name
            cuisine.text = restaurant.cuisines

            Glide.with(image.context)
                .load(restaurant.featuredImage)
                .optionalCenterCrop()
                .into(image)

            // TODO Milestone4 (03) Pass restaurant id to RestaurantDetailActivity
        }

        init {
            name = v.findViewById(R.id.restaurant_name)
            cuisine = v.findViewById(R.id.restaurant_cuisine)
            image = v.findViewById(R.id.restaurant_cover)
        }
    }

    companion object {
        private val TAG = RestaurantListAdapter::class.java.simpleName
    }
}