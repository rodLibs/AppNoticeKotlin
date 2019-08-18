package com.example.appnewskotlin.mvp.list_news

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.pojo.Category
import com.example.appnewskotlin.data.database.entity.Item
import com.example.appnewskotlin.mvp.adapters.AdapterRecycle
import com.example.appnewskotlin.mvp.details_new.DetailNewsActivity
import com.example.appnewskotlin.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert



class ListNewsActivity : AppCompatActivity(), ListNewsInterface.View, ItemClickListener {



    var mPresenter: ListNewsInterface.Presenter? = null
    var adapterRecycle: AdapterRecycle? = null
    var isFavorite = false
    var category: Category? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        showProgress()
        category = intent.getParcelableExtra("category") as Category
        mPresenter = ListNewsPresenter(this,this)
        mPresenter?.getNews(category?.url!!)
        txtCategory.text = category?.name
    }


    private fun showProgress(){
        progress.visibility = View.VISIBLE
        progress.isIndeterminate = true
    }

    private fun hideProgress(){
        progress.visibility = View.INVISIBLE
    }



    fun btFavorite(v: View){
        isFavorite = true
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
                    isFavorite = false
                    mPresenter?.getNews(category?.url!!)
                }
                if (isFavorite) {
                    txtCategory.text = getString(R.string.news_favorites)
                }else{
                    txtCategory.text = category?.name
                }
                hideProgress()
        }
    }



    override fun onItemClick(position: Int, news: Item) {
        startActivityForResult(Intent(this@ListNewsActivity,DetailNewsActivity::class.java).putExtra("news",news),100)
    }



    override fun showMessageErro(message: String) {
        hideProgress()
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



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            if (isFavorite) {
                mPresenter?.getNews(Constants.FAVORITE)
            }
        }
    }
}