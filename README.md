# RestaurantFinder
This is a sample app to showcase the basics of Android development. It is a simple two screen app. The first screen lists down restaurants around your location. Clicking on a restaurant navigates you to the second screen, which displays the details of the restaurant. 

This app demonstrates the use of following components:
* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to store and manage UI-related data in a lifecycle conscious way
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* RxJava for reactive programming
* [Room](https://developer.android.com/topic/libraries/architecture/room.html), with RxJava's [Flowable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Flowable.html) objects for database access
