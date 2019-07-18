package com.example.appnewskotlin.mvp.list_news

import android.view.View
import com.example.appnewskotlin.data.model.Item

interface ItemClickListener {
    fun onItemClick(position: Int, news: Item)
}