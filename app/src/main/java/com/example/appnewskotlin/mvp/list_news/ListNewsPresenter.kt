package com.example.appnewskotlin.mvp.list_news

import android.content.Context
import com.example.appnewskotlin.data.database.database.DatabaseHelper
import com.example.appnewskotlin.data.database.entity.Item
import com.example.appnewskotlin.data.network.CallbackNetwork
import com.example.appnewskotlin.data.network.Network
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import org.jetbrains.anko.doAsync

class ListNewsPresenter(var mView: ListNewsInterface.View, var context: Context): ListNewsInterface.Presenter {


    var model: ListNewsInterface.Model = ListNewsModel(this, context)


    override fun getNews(query_news: String) {
        model.getListNews(query_news)
    }
    override fun returnListNews(listNews: ArrayList<Item>?) {
        mView.showNews(listNews)
    }



    override fun returnMessageErro(message: String) {
        mView.showMessageErro(message)
    }
}