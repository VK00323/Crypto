package com.example.crypto.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import retrofit2.http.Headers


data class CoinInfoListOfData (    @SerializedName("Data")

    @Expose
    private val data: List<Datum>? = null
)