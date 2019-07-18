package com.example.appnewskotlin.mvp.details_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Item

class DetailNewsActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)


        var news = intent.getParcelableExtra<Item>("news")
        Log.i("ITEM",news.title)
    }


}
