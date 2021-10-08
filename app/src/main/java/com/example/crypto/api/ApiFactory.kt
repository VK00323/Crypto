package com.example.crypto.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
//    5
    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
//объект ретрофит который умеет реализовывать интерфейс apiService
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())//gson превращается в объект
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()
//    retrofit создаст реализацию интерфейса
    val apiService= retrofit.create(ApiService::class.java)
}