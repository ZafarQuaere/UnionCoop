package com.example.unioncoop.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.unioncoop.R
import com.example.unioncoop.ui.adapter.ArticleListAdapter
import com.example.unioncoop.utils.Constants
import com.example.unioncoop.viewmodel.BaseViewModel


class MainActivity : AppCompatActivity() {
    lateinit var baseViewModel: BaseViewModel
    lateinit var adapter: ArticleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseViewModel = ViewModelProviders.of(this)[BaseViewModel::class.java]
        baseViewModel.callArticleListApi(this,Constants.sampleKey)
    }
}