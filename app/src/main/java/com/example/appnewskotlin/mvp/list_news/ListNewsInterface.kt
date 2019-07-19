package com.example.appnewskotlin.mvp.list_news

import com.example.appnewskotlin.data.model.Item

interface ListNewsInterface {

    interface Presenter{
        fun getNews(query_news: String)
    }

    interface View{
        fun showNews(listNews: ArrayList<Item>?)
        fun showMessageErro(message: String)
    }
}