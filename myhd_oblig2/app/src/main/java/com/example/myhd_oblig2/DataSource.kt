package com.example.myhd_oblig2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//TODO hente data inn her

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<AlpacaParty>
}