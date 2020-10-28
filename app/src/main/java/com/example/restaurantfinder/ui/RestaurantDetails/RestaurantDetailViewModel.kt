package com.example.restaurantfinder.ui.RestaurantDetails

import androidx.lifecycle.*
import com.example.restaurantfinder.persistence.RestaurantDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// TODO Milestone4 (05) Create RestaurantDetailViewModel
class RestaurantDetailViewModel(private val database: RestaurantDao) : ViewModel() {
    private val liveData = MutableLiveData(BroadcastDetailViewState())
    fun getLiveData(): LiveData<BroadcastDetailViewState> = liveData

    fun loadData(restaurantId: Int) {
        liveData.value?.let {
            if (it.error == null && it.restaurant != null) {
                return
            }
        }

        database.getRestaurantById(restaurantId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { liveData.postValue(liveData.value?.onLoading()) }
            .subscribe(
                {
                    liveData.value = liveData.value?.onDataLoaded(it)
                },
                {
                    liveData.value = liveData.value?.onError(it)
                }
            )
    }

    open class Factory(private val database: RestaurantDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantDetailViewModel(
                database = this.database
            ) as T
        }
    }
}