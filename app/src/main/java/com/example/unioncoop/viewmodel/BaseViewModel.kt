package com.example.unioncoop.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unioncoop.model.ApiResponse
import com.example.unioncoop.services.NetworkInterface
import com.example.unioncoop.services.NetworkResult
import com.example.unioncoop.services.ServiceBuilder
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseViewModel : ViewModel() {

    var responseData: MutableLiveData<NetworkResult<ApiResponse>> = MutableLiveData()

    fun callArticleListApi(mContext: Context, sampleKey: String) {
        viewModelScope.launch {
            try {
                responseData.value = NetworkResult.Loading()
                val articleCall = ServiceBuilder.buildService(NetworkInterface::class.java)
                val request = articleCall.getArticleList(sampleKey)
                request.enqueue(object : Callback<ApiResponse>{
                    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                        println("Network Response: ${response.toString()}")
                        responseData.value = NetworkResult.Success(response.body())
                    }

                    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                        println("Network Response: ${t.message}")
                        responseData.value = NetworkResult.Error(t.message)
                    }

                })
            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }
}