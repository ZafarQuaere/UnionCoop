package com.example.unioncoop.services

import com.example.unioncoop.model.ApiResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {
    @Headers(
        "Content-Type: application/json",
        "App-ID: c5555ca5-304f-4f7a-918f-bc6963b55c5e",
        "Password: 51Kjxaeudnnadb060520190ADMIN3360520190345@ucs.ae"
    )
    @GET("api-key={apiKey}")
    suspend fun getArticleList(@Path("apiKey") apiKey: String): Call<ApiResponse>
}