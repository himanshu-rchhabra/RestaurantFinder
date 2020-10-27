package com.example.restaurantfinder.persistence

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("featured_image")
    val featuredImage: String,

    @SerializedName("average_cost_for_two")
    val costForTwo: Int,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("cuisines")
    val cuisines: String,

    @SerializedName("timings")
    val timings: String
)