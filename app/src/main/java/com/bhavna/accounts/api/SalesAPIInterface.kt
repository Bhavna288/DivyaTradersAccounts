package com.bhavna.accounts.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface SalesAPIInterface {
    @GET("sales")
    fun getSales(@Header("Ocp-Apim-Subscription-Key") apiKey: String): Call<ArrayList<Sale?>>?
}