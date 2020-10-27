package com.example.restaurantfinder.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantsDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    companion object {

        @Volatile
        private var INSTANCE: RestaurantsDatabase? = null

        fun getInstance(context: Context): RestaurantsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RestaurantsDatabase::class.java, "Restaurant.db"
            )
                .build()
    }
}
