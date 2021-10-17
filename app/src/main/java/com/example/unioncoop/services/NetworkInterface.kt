package com.example.unioncoop.services

import com.example.unioncoop.model.ApiResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {
//    @Headers({""})
    @GET("api-key={apiKey}")
    suspend fun getArticleList(@Path("apiKey") apiKey: String): Call<ApiResponse>
}