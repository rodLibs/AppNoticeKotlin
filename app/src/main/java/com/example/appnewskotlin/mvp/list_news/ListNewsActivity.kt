package com.example.appnewskotlin.mvp.list_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Item
import com.example.appnewskotlin.data.network.Network
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import org.jetbrains.anko.alert

class ListNewsActivity : AppCompatActivity(), ListNewsInterface.View {



    var mPresenter: ListNewsInterface.Presenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = ListNewsPresenter(this,this)
        mPresenter?.getNews(Network.QUERY_NEWS_BRAZIL)
    }








    override fun showNews(listNews: MutableList<Item>?) {
        runOnUiThread {
            if (listNews != null && listNews.isNotEmpty()){
                for (item in listNews){
                    Log.i("ITEM",item.title)
                }
            }else {
                Log.i("ITEM", "lista vazia")
            }
        }
    }






    override fun showMessageErro(message: String) {
        setDialog(message)
    }


    private fun setDialog(message: String){
        runOnUiThread {
            alert {
                this.message = message
                positiveButton("Ok"){
                    it.dismiss()
                }
            }.show()
        }
    }
}