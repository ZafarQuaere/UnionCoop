package com.example.unioncoop.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unioncoop.R
import com.example.unioncoop.model.ApiResult

class ArticleListAdapter(val context: Context,val articles:List<ApiResult>) :
    RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recylcler_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textArticleTitle.text = articles[position].title
        holder.textArticleSubTitle.text = articles[position].abstract
        holder.textPublishedDate.text = articles[position].published_date
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class  ViewHolder internal constructor(val mView: View) : RecyclerView.ViewHolder(mView) {
        val imgProfile: ImageView = mView.findViewById(R.id.imgProfile)
        val textArticleTitle: TextView = mView.findViewById(R.id.textArticleTitle)
        val textArticleSubTitle: TextView = mView.findViewById(R.id.textArticleSubTitle)
        val textPublishedDate: TextView = mView.findViewById(R.id.textPublishedDate)
    }

}