package com.example.mvvmkoin.retrofit

import com.example.mvvmkoin.model.Product
import com.example.mvvmkoin.model.ProductList
import com.example.mvvmkoin.model.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiInterface {

    @GET("b/67684fd1acd3cb34a8bdd8b9?meta=false")
    suspend fun getTweet(): Response<ProductList>

    @GET("b/67684fd1acd3cb34a8bdd8b9?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<Tweet>>

    @GET("b/67684fd1acd3cb34a8bdd8b9?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>


    @GET("b/6766579fad19ca34f8deab20?meta=false")
    suspend fun getProducts(): Response<List<Product>>

}