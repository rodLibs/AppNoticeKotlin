package com.example.appnewskotlin.mvp.list_news

import com.example.appnewskotlin.data.database.entity.Item

interface ListNewsInterface {

    interface Presenter{
        fun getNews(query_news: String)
        fun returnListNews(listNews: ArrayList<Item>?)
        fun returnMessageErro(message: String)
    }

    interface View{
        fun showNews(listNews: ArrayList<Item>?)
        fun showMessageErro(message: String)
    }


    interface Model{
        fun getListNews(query_news: String)
    }
}