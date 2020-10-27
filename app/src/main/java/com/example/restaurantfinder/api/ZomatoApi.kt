package com.example.restaurantfinder.api

import android.util.Log
import com.example.restaurantfinder.persistence.Restaurant
import com.google.gson.annotations.SerializedName
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ZomatoApi {

    @GET("/search")
    suspend fun getRestaurants(
        @Query("user-key") key: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("radius") radius: Double // in metres
    ): RestaurantListResponse

    @GET("/restaurant")
    suspend fun getRestaurantDetails(
        @Query("user-key") key: String,
        @Query("res_id") id: Int
    ): Restaurant


    class RestaurantListResponse(
        @SerializedName("restaurants")
        val restaurants: List<Restaurant>
    )

    companion object {
        private const val BASE_URL = "https://www.reddit.com/"

        fun create(): ZomatoApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(HttpUrl.parse(BASE_URL)!!)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ZomatoApi::class.java)
        }
    }
}