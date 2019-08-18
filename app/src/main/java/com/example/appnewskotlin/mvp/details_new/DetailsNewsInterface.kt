package com.example.appnewskotlin.mvp.details_new

import com.example.appnewskotlin.data.database.entity.Item

interface DetailsNewsInterface {


    interface Presenter{
        fun insertNewsDatabase(news: Item?)
        fun removeNewsDatabase(news: Item?)

        fun returnInsertNewsDatabase(news: Item?)
        fun returnRemoveNewsDatabase(news: Item?)
    }


    interface View{
        fun showResult(news: Item?)
    }


    interface Model{
        fun requestInsertNewsDatabase(news: Item?)
        fun requestRemoveNewsDatabase(news: Item?)
    }
}