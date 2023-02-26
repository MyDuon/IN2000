package com.example.myhd_oblig2

import retrofit2.http.GET
import retrofit2.Call

interface ApiInterface {
    @GET("Parties")
    fun getPartiesList () : Call<List<AlpacaParty>>
}