package com.example.crypto.api

import com.example.crypto.pojo.CoinInfoListOfData
import com.example.crypto.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
//       2
    @Query(QUERY_PARAM_API_KEY) apiKey: String ="8f26dbe6b52a5e8bab5f1cb814da2bf1b5cfd7010615293e1e771e26541a4fa1",
    @Query(QUERY_PARAM_LIMIT) limit: Int =10,
    @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY): Single<CoinInfoListOfData>
//3 Загружает полную информацию
    @GET("pricemultifull")
    fun getFullPriceList(
    @Query(QUERY_PARAM_API_KEY) apiKey: String ="8f26dbe6b52a5e8bab5f1cb814da2bf1b5cfd7010615293e1e771e26541a4fa1",
    @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String,
    @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String = CURRENCY

    ): Single<CoinPriceInfoRawData>


//    1
    companion object{
    private const val QUERY_PARAM_API_KEY ="api_key"
    private const val QUERY_PARAM_LIMIT = "limit"
    private const val QUERY_PARAM_TO_SYMBOL = "tsym"
    private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
    private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
    private const val CURRENCY  = "USD"

    }
}