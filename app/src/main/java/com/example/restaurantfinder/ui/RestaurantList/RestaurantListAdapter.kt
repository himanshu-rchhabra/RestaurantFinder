package com.example.restaurantfinder.ui.RestaurantList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantfinder.R
import com.example.restaurantfinder.persistence.Restaurant

class RestaurantListAdapter(private var restaurantList: List<Restaurant> = emptyList()) :
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

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView

        fun bindView(restaurant: Restaurant) {
            name.text = restaurant.name
        }

        init {
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
            name = v.findViewById(R.id.restaurant_name)
        }
    }

    companion object {
        private val TAG = RestaurantListAdapter::class.java.simpleName
    }
}