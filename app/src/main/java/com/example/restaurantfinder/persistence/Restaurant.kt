package com.example.restaurantfinder.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

// TODO Milestone1 (04) Define data model

// TODO Milestone3 (02) Setup model for database
@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: Int,

    @ColumnInfo
    @SerializedName("name")
    val name: String,

    @ColumnInfo
    @SerializedName("featured_image")
    val featuredImage: String,

    @ColumnInfo
    @SerializedName("average_cost_for_two")
    val costForTwo: Int,

    @ColumnInfo
    @SerializedName("currency")
    val currency: String,

    @ColumnInfo
    @SerializedName("cuisines")
    val cuisines: String,

    @ColumnInfo
    @SerializedName("timings")
    val timings: String
)