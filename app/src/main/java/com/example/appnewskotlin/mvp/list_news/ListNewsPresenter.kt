package com.example.appnewskotlin.mvp.list_news

import android.content.Context
import com.example.appnewskotlin.data.database.DatabaseHelper
import com.example.appnewskotlin.data.model.Item
import com.example.appnewskotlin.data.model.Rss
import com.example.appnewskotlin.data.network.CallbackNetwork
import com.example.appnewskotlin.data.network.Network
import com.google.gson.Gson
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import org.jetbrains.anko.doAsync

class ListNewsPresenter(var mView: ListNewsInterface.View, var context: Context): ListNewsInterface.Presenter {


    var databaseHelper = DatabaseHelper.getInstance(context)



    override fun getNews(query_news: String) {
        if (query_news == "favorites"){
            doAsync {
                val listNews = databaseHelper?.itemDAO()?.getAllNews()
                mView.showNews(ArrayList(listNews))
            }
        }else {
            val net = Network(context)
            net.getNews(query_news, object : CallbackNetwork {
                override fun onSucess(code: Int, response: String?) {
                    if (code == 200) {
                        parseXmlToJson(response!!)
                    } else {
                        mView.showMessageErro("$code")
                    }
                }

                override fun onError(code: Int, error: String?) {
                    mView.showMessageErro("$error $code")
                }
            })
        }
    }




    private fun parseXmlToJson(value: String){
        val xmlToJson = XmlToJson.Builder(value).build().toJson()
        val jsonArray = xmlToJson?.getJSONObject("rss")?.getJSONObject("channel")?.getJSONArray("item")
        val list = ArrayList<Item>()
        for (i in 0 until jsonArray?.length()!!){
            val jsonItem = jsonArray.getJSONObject(i)

            var image: String? = null
            if (jsonItem.has("media:content")){
                image = jsonItem.getJSONObject("media:content").getString("url")
            }
            list.add(Item(null,jsonItem.getString("title"),jsonItem.getString("link"),jsonItem.getString("description"),
                                   jsonItem.getString("category"),jsonItem.getString("pubDate"),image))
        }
        mView.showNews(list)
    }
}