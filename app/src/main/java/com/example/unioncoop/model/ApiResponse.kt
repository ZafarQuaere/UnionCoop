package com.example.unioncoop.model

import android.icu.text.CaseMap
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class ApiResponse(val status: String,val copyright: String,val num_results: Int,val results: List<ApiResult>)

data class ApiResult(val uri: String, val url: String,val id:String,val title: String,val abstract: String, val published_date: String,
                    val media: List<Media>)

@Keep // it keeps data class away from obfuscation.
data class Media(@SerializedName("media-metadata") val media_metadata: List<MediaMetaData>)

data class MediaMetaData (val url:String)
