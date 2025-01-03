package com.example.mvvmkoin.repo

import android.util.Log
import com.example.mvvmkoin.model.Tweet
import com.example.mvvmkoin.retrofit.ApiInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

const val TAG = "MVVM"

class Repository constructor(private val apiInterface: ApiInterface) {

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() = _tweets

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    suspend fun getCategories() {
        val response = apiInterface.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)

            Log.d(TAG, "getCategories: ${categories.value}")
        }
    }

    suspend fun getTweets(category: String) {
        val result = apiInterface.getTweets("tweets[?(@.category==\"$category\")]")
        if (result.isSuccessful && result.body() != null) {
            println("tweet data  > " + result.body())
            _tweets.emit(result.body()!!)
        }
    }

}