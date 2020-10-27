package com.example.restaurantfinder.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey
    @ColumnInfo
    val id: Int,

    @ColumnInfo
    val name: String?,

    @ColumnInfo
    val url: String?,

    @ColumnInfo
    val featuredImage: String?,

    @ColumnInfo
    val costForTwo: Int?,

    @ColumnInfo
    val currency: String?
)