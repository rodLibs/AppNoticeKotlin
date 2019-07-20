package com.example.appnewskotlin.mvp.details_new

import com.example.appnewskotlin.data.model.Item

interface DetailsNewsInterface {

    interface Presenter{
        fun insertNewsDatabase(news: Item?)
        fun removeNewsDatabase(news: Item?)
    }

    interface View{
        fun showResult(news: Item?)
    }

}