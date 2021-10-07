package com.example.unioncoop.services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {

    @GET
    fun getArticleList(@Query("api-key") apiKey: String): Call<JsonObject>
}