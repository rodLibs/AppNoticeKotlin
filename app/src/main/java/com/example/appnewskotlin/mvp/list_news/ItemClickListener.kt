package com.example.appnewskotlin.mvp.list_news

import com.example.appnewskotlin.data.database.entity.Item


interface ItemClickListener {
    fun onItemClick(position: Int, news: Item)
}