package com.example.restaurantfinder.api

import android.util.Log
import com.example.restaurantfinder.persistence.Restaurant
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ZomatoApi {

    @GET("api/v2.1/search")
    fun getRestaurants(
        @Header("user-key") key: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("radius") radius: String // in metres
    ): Observable<RestaurantListResponse>

    @GET("/restaurant")
    fun getRestaurantDetails(
        @Query("user-key") key: String,
        @Query("res_id") id: Int
    ): Observable<Restaurant>


    open class RestaurantListResponse(
        @SerializedName("results_found")
        val resultsFound: Int,

        @SerializedName("restaurants")
        val restaurants: List<RestaurantResponse>
    )

    open class RestaurantResponse(
        @SerializedName("restaurant")
        val restaurant: Restaurant
    )

    companion object {
        private const val BASE_URL = "https://developers.zomato.com/"

        fun create(): ZomatoApi {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
            return Retrofit.Builder()
                .baseUrl(HttpUrl.parse(BASE_URL)!!)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ZomatoApi::class.java)
        }
    }
}