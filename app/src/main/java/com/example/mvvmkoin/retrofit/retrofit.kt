package com.example.mvvmkoin.retrofit

import com.example.mvvmkoin.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun retroApiInterface(retrofit: Retrofit): ApiInterface {
    return retrofit.create(ApiInterface::class.java)
}