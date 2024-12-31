package com.example.mvvmkoin.di

import androidx.lifecycle.SavedStateHandle
import com.example.mvvmkoin.repo.Repository
import com.example.mvvmkoin.retrofit.getRetrofit
import com.example.mvvmkoin.retrofit.retroApiInterface
import com.example.mvvmkoin.viewmodel.CategoryViewModel
import com.example.mvvmkoin.viewmodel.TweetsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        getRetrofit()
    }

    single {
        retroApiInterface(get())
    }

    single { Repository(get()) }

    viewModel {
        CategoryViewModel(get())
    }

    viewModel {
        (savedStateHandle: SavedStateHandle) -> TweetsViewModel(get(), savedStateHandle)
    }


}