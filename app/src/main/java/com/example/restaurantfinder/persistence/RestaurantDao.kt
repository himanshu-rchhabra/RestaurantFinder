package com.example.restaurantfinder.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

// TODO Milestone3 (03) Define Restaurant Dao for database interactions
@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant WHERE id = :id")
    fun getRestaurantById(id: Int): Flowable<Restaurant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRestaurants(restaurants: List<Restaurant>): Completable
}