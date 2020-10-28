# RestaurantFinder
This is a sample app to showcase the basics of Android development. It is a simple two screen app. The first screen lists down restaurants around your location. Clicking on a restaurant navigates you to the second screen, which displays the details of the restaurant. 

This app demonstrates the use of following components:
* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to store and manage UI-related data in a lifecycle conscious way
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* RxJava for reactive programming
* [Room](https://developer.android.com/topic/libraries/architecture/room.html), with RxJava's [Flowable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Flowable.html) objects for database access


## How to use this repo while taking the course

This repository has been divided into the following branches
* [origin/starter-code](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/origin/starter-code)
* [origin/milestone-1](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/origin/milestone-1)
* [origin/milestone-2](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/origin/milestone-2)
* [origin/milestone-3](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/origin/milestone-3)
* [hichha/demo](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/hichha/demo)

Each branch has a list of TODOs, completing them, in order will help you reach the next milestone. If you get stuck at any point, you can checkout the next milestone branch and check the solution for the TODOs. 
The [demo](https://github.com/himanshu-rchhabra/RestaurantFinder/tree/hichha/demo) branch contains the entire solution, with the TODOs placed along the solution, to make searching for them easier.

**Step 1: Clone the repo**

As you go through the course, you'll be instructed to clone the different exercise repositories, so you don't need to set these up now. You can clone a repository from github in a folder of your choice with the command:

```bash
git clone https://github.com/himanshu-rchhabra/RestaurantFinder.git
```

**Step 2: Check out the milestone branch**

Start with the origin/starter-code branch. Once you are done with it, checkout the next milestone branch. 

```bash
git checkout BRANCH_NAME
```

**Step 3: Find and complete the TODOs**

Once you've checked out the branch, you'll have the code in the exact state you need. You'll even have TODOs, which are special comments that tell you all the steps you need to reach the next milestone. You can easily navigate to all the TODOs using Android Studio's TODO tool. To open the TODO tool, click the button at the bottom of the screen that says TODO. This will display a list of all comments with TODO in the project. 

We've numbered the TODO steps so you can do them in order:
