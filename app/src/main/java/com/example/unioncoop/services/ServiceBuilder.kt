package com.example.unioncoop.services


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {

    private const val baseUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json/"
//    private const val baseUrl = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key="

    private val okHttpClient = OkHttpClient.Builder().connectTimeout(100,TimeUnit.SECONDS).
                                                readTimeout(100,TimeUnit.SECONDS)

    private val builder = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                                        .client(okHttpClient.build())

    //Retrofit instance
    private val retrofit = builder.build()

    fun<T> buildService(serviceType : Class<T>):T{
        return retrofit.create(serviceType)
    }

}