package com.example.restaurantfinder.ui.RestaurantList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantfinder.BuildConfig
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.persistence.RestaurantDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RestaurantListViewModel(
    private val api: ZomatoApi,
    private val database: RestaurantDao
) : ViewModel() {

    private val liveData = MutableLiveData(RestaurantListViewState())
    fun getLiveData(): LiveData<RestaurantListViewState> = liveData

    fun loadData() {
        // Don't reload data if already loaded without errors
        liveData.value?.let {
            if (it.error == null && !it.restaurants.isNullOrEmpty()) {
                return
            }
        }

        api.getRestaurants(
            key = BuildConfig.API_KEY,
            lat = "12.9217875",
            lon = "77.6666987",
            radius = "500"
        ).subscribeOn(Schedulers.io())
            .doOnSubscribe { liveData.postValue(liveData.value?.onLoading()) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    liveData.value =
                        liveData.value?.onDataLoaded(it.restaurants.map { it.restaurant })
                    saveData(it)
                },
                { error ->
                    run {
                        liveData.value = liveData.value?.onError(error)
                        Log.e(TAG, "Unable to get username", error)
                    }
                })

    }

    private fun saveData(it: ZomatoApi.RestaurantListResponse) {
        database.saveRestaurants(it.restaurants.map { it.restaurant })
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    open class Factory(
        private val api: ZomatoApi,
        private val database: RestaurantDao
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(
                api = this.api,
                database = this.database
            ) as T
        }
    }

    companion object {
        private val TAG = RestaurantListViewModel::class.java.simpleName
    }
}