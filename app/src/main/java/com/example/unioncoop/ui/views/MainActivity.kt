package com.example.unioncoop.ui.views

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.example.unioncoop.R
import com.example.unioncoop.ui.adapter.ArticleListAdapter
import com.example.unioncoop.utils.Constants
import com.example.unioncoop.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {
    lateinit var baseViewModel: BaseViewModel
    lateinit var adapter: ArticleListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseViewModel = ViewModelProviders.of(this)[BaseViewModel::class.java]
        btnLoadData.setOnClickListener{
            baseViewModel.callArticleListApi(this,Constants.sampleKey)
        }

    }
}