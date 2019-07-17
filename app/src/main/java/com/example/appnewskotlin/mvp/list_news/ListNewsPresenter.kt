package com.example.appnewskotlin.mvp.list_news

import android.content.Context
import com.example.appnewskotlin.data.model.Rss
import com.example.appnewskotlin.data.network.CallbackNetwork
import com.example.appnewskotlin.data.network.Network
import com.google.gson.Gson
import fr.arnaudguyon.xmltojsonlib.XmlToJson

class ListNewsPresenter(var mView: ListNewsInterface.View, var context: Context): ListNewsInterface.Presenter {


    val gson = Gson()


    override fun getNews(query_news: String) {
        val net = Network(context)
        net.getNews(query_news, object: CallbackNetwork{
            override fun onSucess(code: Int, response: String?) {
               if (code == 200){
                   parseXmlToJson(response!!)
               } else{
                   mView.showMessageErro("$code")
               }
            }
            override fun onError(code: Int, error: String?) {
                mView.showMessageErro("$error $code")
            }
        })
    }




    private fun parseXmlToJson(value: String){
        val xmlToJson = XmlToJson.Builder(value).build().toJson()
        val valueRss = xmlToJson?.getJSONObject("rss").toString()

        val rss = gson.fromJson(valueRss, Rss::class.java)
        mView.showNews(rss.channel?.item)
    }
}