package com.example.restaurantfinder.persistence

import com.google.gson.annotations.SerializedName

// TODO Milestone3 (02) Setup model for database
// TODO Milestone3 (03) Define Restaurant Dao for database interactions
// TODO Milestone3 (04) Setup database

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