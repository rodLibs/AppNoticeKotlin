package com.example.appnewskotlin.mvp.list_news

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Item
import com.example.appnewskotlin.data.network.Network
import com.example.appnewskotlin.mvp.adapters.AdapterRecycle
import com.example.appnewskotlin.mvp.details_new.DetailNewsActivity
import com.example.appnewskotlin.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert



class ListNewsActivity : AppCompatActivity(), ListNewsInterface.View, ItemClickListener {



    var mPresenter: ListNewsInterface.Presenter? = null
    var adapterRecycle: AdapterRecycle? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        mPresenter = ListNewsPresenter(this,this)
        mPresenter?.getNews(Constants.QUERY_NEWS_BRAZIL)
    }



    fun btFavorite(v: View){
        mPresenter?.getNews(Constants.FAVORITE)
    }




    @SuppressLint("WrongConstant")
    override fun showNews(listNews: ArrayList<Item>?) {
        runOnUiThread {
                adapterRecycle = AdapterRecycle(this@ListNewsActivity, listNews!!,this@ListNewsActivity)
                recycleView.adapter = adapterRecycle
                val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recycleView.layoutManager = layoutManager
                swipeRefresh.isRefreshing = false
                swipeRefresh.setOnRefreshListener {
                    mPresenter?.getNews(Constants.QUERY_NEWS_BRAZIL)
                }
        }
    }



    override fun onItemClick(position: Int, news: Item) {
        startActivity(Intent(this@ListNewsActivity,DetailNewsActivity::class.java).putExtra("news",news))
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