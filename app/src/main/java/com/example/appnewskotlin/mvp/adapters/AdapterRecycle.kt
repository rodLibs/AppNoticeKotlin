package com.example.appnewskotlin.mvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Item
import com.example.appnewskotlin.mvp.list_news.ItemClickListener


class AdapterRecycle(var context: Context, var listNews: ArrayList<Item>, var listener: ItemClickListener): RecyclerView.Adapter<AdapterRecycle.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_list_news, parent,false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }



    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val news = listNews[position]
        viewHolder.txtTitle.text = news.title
        viewHolder.txtDate.text = "${news.category} - ${news.pubDate?.replace(" -0000","")}"

        if (news.image != null) {
            Glide.with(context).load(news.image).centerCrop().placeholder(R.color.colorGrayBackgroundDarkFont).into(viewHolder.img)
        }else{
            Glide.with(context).load("").placeholder(R.color.colorGrayBackgroundDarkFont).into(viewHolder.img)
        }
        viewHolder.itemView.setOnClickListener{
            listener.onItemClick(position, news)
        }
    }



    override fun getItemCount(): Int = listNews.size



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var txtDate: TextView = itemView.findViewById(R.id.txtDate)
        var img: ImageView = itemView.findViewById(R.id.img)
    }
}