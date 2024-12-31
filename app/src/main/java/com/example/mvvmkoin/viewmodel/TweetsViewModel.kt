package com.example.mvvmkoin.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmkoin.model.Tweet
import com.example.mvvmkoin.repo.Repository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TweetsViewModel constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweets: StateFlow<List<Tweet>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("cat") ?: "web"
            repository.getTweets(category)
        }
    }
}