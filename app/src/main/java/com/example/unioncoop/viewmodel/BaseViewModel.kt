package com.example.unioncoop.viewmodel

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import com.example.unioncoop.services.NetworkInterface
import com.example.unioncoop.services.ServiceBuilder
import java.io.File

class BaseViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.M)
    fun callArticleListApi(mContext: Context, sampleKey: String) {

        val articleCall = ServiceBuilder.buildService(NetworkInterface::class.java)
        articleCall.getArticleList(sampleKey)

    }


}