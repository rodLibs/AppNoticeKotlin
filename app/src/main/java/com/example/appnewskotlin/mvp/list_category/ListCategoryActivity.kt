package com.example.appnewskotlin.mvp.list_category

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Category
import com.example.appnewskotlin.mvp.adapters.AdapterRecycleCategory
import com.example.appnewskotlin.mvp.list_news.ListNewsActivity
import kotlinx.android.synthetic.main.activity_list_category.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ListCategoryActivity : AppCompatActivity(), ListCategoryInterface.View, ItemClickCategoryListener {


    private var mPresenter: ListCategoryInterface.Presenter? = null
    private var adapterRecycleCategory: AdapterRecycleCategory? = null
    private val dfDate = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)
        supportActionBar?.hide()

        mPresenter = ListCategoryPresenter(this@ListCategoryActivity,this@ListCategoryActivity)
        mPresenter?.getListCategory()
        txtDate.text = dfDate.format(Date())

    }



    @SuppressLint("WrongConstant")
    override fun showListCategory(listCategory: ArrayList<Category>) {
        adapterRecycleCategory = AdapterRecycleCategory(this@ListCategoryActivity, listCategory,this@ListCategoryActivity)
        recycleView.adapter = adapterRecycleCategory
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val layoutManager = GridLayoutManager(this@ListCategoryActivity, 2, GridLayoutManager.VERTICAL, false)
        recycleView.layoutManager = layoutManager
    }


    override fun onItemClick(position: Int, category: Category) {
        startActivity(Intent(this@ListCategoryActivity, ListNewsActivity::class.java).putExtra("category",category))
    }
}