package com.example.myapplication.data_sources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerGateway {
    private const val baseUrl: String = "https://jsonplaceholder.typicode.com/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(t: Class<T>): T {
        return retrofit.create(t)
    }
}