package com.example.restaurantfinder.ui.RestaurantList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantfinder.api.ZomatoApi
import com.example.restaurantfinder.persistence.RestaurantDao
import io.reactivex.disposables.CompositeDisposable

class RestaurantListViewModel(
    private val database: RestaurantDao,
    private val api: ZomatoApi
) : ViewModel() {

    private val liveData = MutableLiveData(RestaurantListViewState())
    fun getLiveData(): LiveData<RestaurantListViewState> = liveData

    private val disposable = CompositeDisposable()

    fun loadData() {
        // Dont reload data, if it is loading, or already loaded without errors
        liveData.value?.let {
            if (it.isLoading
                || (it.error == null && !it.restaurants.isNullOrEmpty())
            ) {
                return
            }
        }

    }

    open class Factory(
        private val database: RestaurantDao,
        private val api: ZomatoApi
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(
                database = this.database,
                api = this.api
            ) as T
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}